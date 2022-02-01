package com.tencent.mobileqq.emoticonview;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.popanim.EmoticonPopOutHelper;

public class EmoticonHelperProvider
  implements IEmoticonHelperProvider
{
  private static final String TAG = "EmoticonHelperProvider";
  private static final int THRESHOLD = 5;
  private SparseArrayCompat<AbstractEmoticonPanelHelper> helpers = new SparseArrayCompat();
  private SparseArrayCompat<SparseArrayCompat<AbstractEmoticonPanelHelper>> lifecycleObservers = new SparseArrayCompat(10);
  
  public EmoticonHelperProvider(EmoticonPanelController paramEmoticonPanelController)
  {
    register(1, new EmoticonPanelExtendHelper(paramEmoticonPanelController));
    register(2, new EmoticonPanelFavHelper(paramEmoticonPanelController));
    register(3, new EmoticonPanelCameraHelper(paramEmoticonPanelController));
    register(4, new EmoticonPanelSystemAndEmojiHelper(paramEmoticonPanelController));
    register(5, new EmoticonPanelMallHelper(paramEmoticonPanelController));
    register(6, new EmoticonPanelSettingHelper(paramEmoticonPanelController));
    register(7, new EmoticonPanelHotPicSearchHelper(paramEmoticonPanelController));
    register(8, new EmoticonPanelTabSortHelper(paramEmoticonPanelController));
    register(10, new EmoticonReportDtHelper(paramEmoticonPanelController));
    register(11, new EmoticonPopOutHelper(paramEmoticonPanelController));
  }
  
  private void check(int paramInt)
  {
    if (this.helpers.get(paramInt) == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoticon helper already exist with id: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void dispatchSate(AbstractEmoticonPanelHelper paramAbstractEmoticonPanelHelper, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 14: 
      paramAbstractEmoticonPanelHelper.onShowPageFinish();
      return;
    case 13: 
      paramAbstractEmoticonPanelHelper.onItemTabClick(paramInt2);
      return;
    case 12: 
      paramAbstractEmoticonPanelHelper.onPullUp();
      return;
    case 11: 
      paramAbstractEmoticonPanelHelper.onPullDown();
      return;
    case 10: 
      paramAbstractEmoticonPanelHelper.onDetachedFromWindow();
      return;
    case 9: 
      paramAbstractEmoticonPanelHelper.onAttachedToWindow();
      return;
    case 8: 
      paramAbstractEmoticonPanelHelper.onDestory();
      return;
    case 7: 
      paramAbstractEmoticonPanelHelper.onPause();
      return;
    case 6: 
      paramAbstractEmoticonPanelHelper.onResume();
      return;
    case 5: 
      paramAbstractEmoticonPanelHelper.onShow();
      return;
    case 4: 
      paramAbstractEmoticonPanelHelper.onHide(paramBoolean);
      return;
    case 3: 
      paramAbstractEmoticonPanelHelper.onPageSelected(paramInt2);
      return;
    case 2: 
      paramAbstractEmoticonPanelHelper.initAfter();
      return;
    }
    paramAbstractEmoticonPanelHelper.initBefore();
  }
  
  public void dispatchLifeCycle(int paramInt)
  {
    dispatchLifeCycle(paramInt, -1, false);
  }
  
  public void dispatchLifeCycle(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.lifecycleObservers.get(paramInt1);
    if (localSparseArrayCompat == null) {
      return;
    }
    int j = localSparseArrayCompat.size();
    int i = 0;
    while (i < j)
    {
      dispatchSate((AbstractEmoticonPanelHelper)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
      i += 1;
    }
  }
  
  public <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt)
  {
    return (AbstractEmoticonPanelHelper)this.helpers.get(paramInt);
  }
  
  public void register(int paramInt, AbstractEmoticonPanelHelper paramAbstractEmoticonPanelHelper)
  {
    this.helpers.put(paramInt, paramAbstractEmoticonPanelHelper);
    int[] arrayOfInt = paramAbstractEmoticonPanelHelper.interestedIn();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.lifecycleObservers.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.lifecycleObservers.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramAbstractEmoticonPanelHelper);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonHelperProvider
 * JD-Core Version:    0.7.0.1
 */