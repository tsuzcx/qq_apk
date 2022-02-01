package com.tencent.mobileqq.emoticonview;

import android.support.v4.util.SparseArrayCompat;

public class EmoticonHelperProvider
{
  public static final int ID_CAMERA_EMOTICON_HELPER = 3;
  public static final int ID_EMOTICON_EXTEND_HELPER = 1;
  public static final int ID_FAV_EMOTICON_HELPER = 2;
  public static final int ID_HOTPIC_SEARCH_EMOTICON_HELPER = 7;
  public static final int ID_MALL_EMOTICON_HELPER = 5;
  public static final int ID_SETTING_EMOTICON_HELPER = 6;
  public static final int ID_SORT_EMOTICON_HELPER = 8;
  public static final int ID_SYSTEM_EMOJI_EMOTICON_HELPER = 4;
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
  }
  
  private void check(int paramInt)
  {
    if (this.helpers.get(paramInt) != null) {
      throw new IllegalArgumentException("emoticon helper already exist with id: " + paramInt);
    }
  }
  
  private void dispatchSate(AbstractEmoticonPanelHelper paramAbstractEmoticonPanelHelper, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramAbstractEmoticonPanelHelper.initBefore();
      return;
    case 2: 
      paramAbstractEmoticonPanelHelper.initAfter();
      return;
    case 9: 
      paramAbstractEmoticonPanelHelper.onAttachedToWindow();
      return;
    case 10: 
      paramAbstractEmoticonPanelHelper.onDetachedFromWindow();
      return;
    case 8: 
      paramAbstractEmoticonPanelHelper.onDestory();
      return;
    case 3: 
      paramAbstractEmoticonPanelHelper.onPageSelected(paramInt2);
      return;
    case 5: 
      paramAbstractEmoticonPanelHelper.onShow();
      return;
    case 4: 
      paramAbstractEmoticonPanelHelper.onHide(paramBoolean);
      return;
    case 7: 
      paramAbstractEmoticonPanelHelper.onPause();
      return;
    }
    paramAbstractEmoticonPanelHelper.onResume();
  }
  
  private void register(int paramInt, AbstractEmoticonPanelHelper paramAbstractEmoticonPanelHelper)
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
  
  public void dispatchLifeCycle(int paramInt)
  {
    dispatchLifeCycle(paramInt, -1, false);
  }
  
  public void dispatchLifeCycle(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.lifecycleObservers.get(paramInt1);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        dispatchSate((AbstractEmoticonPanelHelper)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
  
  public <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt)
  {
    return (AbstractEmoticonPanelHelper)this.helpers.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonHelperProvider
 * JD-Core Version:    0.7.0.1
 */