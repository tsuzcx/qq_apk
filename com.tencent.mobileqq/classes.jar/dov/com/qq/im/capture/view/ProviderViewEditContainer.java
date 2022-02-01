package dov.com.qq.im.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import bmsl;
import bmyx;
import bmzz;
import bnno;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ProviderViewEditContainer
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 100;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bmsl jdField_a_of_type_Bmsl;
  private bmyx jdField_a_of_type_Bmyx;
  private bmzz jdField_a_of_type_Bmzz;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int[] jdField_a_of_type_ArrayOfInt = { 103, 107, 109 };
  private int b = 0;
  
  public ProviderViewEditContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private ProviderView a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 103: 
      return new StaticStickerProviderView(getContext());
    case 107: 
      localObject = new MusicFragmentProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    }
    Object localObject = new VideoCoverPickerProviderView(getContext());
    ((ProviderView)localObject).setNeedTabBar(false);
    return localObject;
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProviderViewEditContainer", 2, new Object[] { "openContainerProviderView view not exsist, id:", Integer.valueOf(paramInt) });
      }
      return false;
      ProviderView localProviderView = a(paramInt);
      localObject = localProviderView;
      if (localProviderView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
        addView(localProviderView);
        localObject = localProviderView;
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      localObject = (StaticStickerProviderView)localObject;
      if (!((StaticStickerProviderView)localObject).d())
      {
        ((StaticStickerProviderView)localObject).a(null);
        ((StaticStickerProviderView)localObject).setOnFaceSelectedListener(this.jdField_a_of_type_Bmsl);
      }
      ((StaticStickerProviderView)localObject).setCaptureScene(this.b);
      ((StaticStickerProviderView)localObject).i();
      ((StaticStickerProviderView)localObject).c();
      if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
        ((StaticStickerProviderView)localObject).a((bnno)paramVarArgs[0]);
      }
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.dip2px(getContext(), 250.0F);
      if (paramVarArgs.height != paramInt)
      {
        paramVarArgs.height = paramInt;
        setLayoutParams(paramVarArgs);
      }
      this.jdField_a_of_type_Int = 103;
      continue;
      localObject = (MusicFragmentProviderView)localObject;
      if (!((MusicFragmentProviderView)localObject).d())
      {
        ((MusicFragmentProviderView)localObject).d(250);
        ((MusicFragmentProviderView)localObject).a(null);
        if (this.jdField_a_of_type_Bmyx != null) {
          ((MusicFragmentProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_Bmyx);
        }
      }
      ((MusicFragmentProviderView)localObject).setCaptureScene(this.b);
      if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
        ((MusicFragmentProviderView)localObject).setMusicProviderView((MusicItemInfo)paramVarArgs[0]);
      }
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.dip2px(getContext(), 250.0F);
      if (paramVarArgs.height != paramInt)
      {
        paramVarArgs.height = paramInt;
        setLayoutParams(paramVarArgs);
      }
      paramVarArgs = getLayoutParams();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramVarArgs.height += this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        setLayoutParams(paramVarArgs);
      }
      this.jdField_a_of_type_Int = 107;
      continue;
      localObject = (VideoCoverPickerProviderView)localObject;
      if (!((VideoCoverPickerProviderView)localObject).d())
      {
        ((VideoCoverPickerProviderView)localObject).setCaptureScene(this.b);
        ((VideoCoverPickerProviderView)localObject).setListener(this.jdField_a_of_type_Bmzz);
        ((VideoCoverPickerProviderView)localObject).a(null);
      }
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Long))) {
        ((VideoCoverPickerProviderView)localObject).setCoverFrameTime(((Long)paramVarArgs[0]).longValue());
      }
      paramVarArgs = getLayoutParams();
      int i = UIUtils.dip2px(getContext(), 185.0F);
      paramInt = i;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramInt = i + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      }
      paramVarArgs.height = paramInt;
      setLayoutParams(paramVarArgs);
      this.jdField_a_of_type_Int = 109;
    }
  }
  
  public void a()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_Int = 100;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!a(paramInt, paramVarArgs)) {}
    while (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    setVisibility(0);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int == 100) || (getVisibility() != 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return false;
    }
    ProviderView localProviderView = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localProviderView != null) {
      return localProviderView.a();
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null) && (getVisibility() == 0)) {
      return this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a(paramMotionEvent);
    }
    return false;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).b();
    }
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  public void setProviderViewListener(bmyx parambmyx)
  {
    this.jdField_a_of_type_Bmyx = parambmyx;
  }
  
  public void setStickerListener(bmsl parambmsl)
  {
    this.jdField_a_of_type_Bmsl = parambmsl;
  }
  
  public void setVideoCoverPickerListener(bmzz parambmzz)
  {
    this.jdField_a_of_type_Bmzz = parambmzz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */