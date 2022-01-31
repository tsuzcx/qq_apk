package dov.com.qq.im.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ProviderViewEditContainer
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 100;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  private ProviderView.ProviderViewListener jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private VideoSegmentPickerProviderView.VideoSegmentPickerListener jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$VideoSegmentPickerListener;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int[] jdField_a_of_type_ArrayOfInt = { 103, 109, 110, 111 };
  private int b = 0;
  
  public ProviderViewEditContainer(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    Object localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProviderViewEditContainer", 2, "openContainerProviderView view not exsist");
      }
      return false;
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
        ((StaticStickerProviderView)localObject).setOnFaceSelectedListener(this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener);
      }
      ((StaticStickerProviderView)localObject).setCaptureScene(this.b);
      ((StaticStickerProviderView)localObject).i();
      ((StaticStickerProviderView)localObject).a();
      if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
        ((StaticStickerProviderView)localObject).a((GestureHelper.ZoomItem)paramVarArgs[0]);
      }
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.a(getContext(), 206.0F);
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
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
          ((MusicFragmentProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener);
        }
      }
      ((MusicFragmentProviderView)localObject).setCaptureScene(this.b);
      if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
        ((MusicFragmentProviderView)localObject).setMusicProviderView((MusicItemInfo)paramVarArgs[0]);
      }
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.a(getContext(), 250.0F);
      if (paramVarArgs.height != paramInt)
      {
        paramVarArgs.height = paramInt;
        setLayoutParams(paramVarArgs);
      }
      this.jdField_a_of_type_Int = 109;
      continue;
      paramVarArgs = (BgmRecognitionProviderView)localObject;
      if (!paramVarArgs.d())
      {
        paramVarArgs.d(250);
        paramVarArgs.a(null);
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
          paramVarArgs.setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener);
        }
      }
      paramVarArgs.setCaptureScene(this.b);
      paramVarArgs.a();
      paramVarArgs = getLayoutParams();
      paramInt = UIUtils.a(getContext(), 250.0F);
      if (paramVarArgs.height != paramInt)
      {
        paramVarArgs.height = paramInt;
        setLayoutParams(paramVarArgs);
      }
      this.jdField_a_of_type_Int = 110;
      continue;
      localObject = (VideoSegmentPickerProviderView)localObject;
      if (!((VideoSegmentPickerProviderView)localObject).d())
      {
        ((VideoSegmentPickerProviderView)localObject).setCaptureScene(this.b);
        ((VideoSegmentPickerProviderView)localObject).setListener(this.jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$VideoSegmentPickerListener);
        ((VideoSegmentPickerProviderView)localObject).a(null);
      }
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = UIUtils.a(getContext(), 95.0F);
      setLayoutParams(localLayoutParams);
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof GestureHelper.ZoomItem)))
      {
        ((VideoSegmentPickerProviderView)localObject).setItems((GestureHelper.ZoomItem)paramVarArgs[0]);
        ((VideoSegmentPickerProviderView)localObject).a();
      }
      this.jdField_a_of_type_Int = 111;
    }
  }
  
  private ProviderView b(int paramInt)
  {
    switch (paramInt)
    {
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    default: 
      return null;
    case 103: 
      return new StaticStickerProviderView(getContext());
    case 109: 
      localObject = new MusicFragmentProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    case 110: 
      localObject = new BgmRecognitionProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    }
    Object localObject = new VideoSegmentPickerProviderView(getContext());
    ((ProviderView)localObject).setNeedTabBar(false);
    return localObject;
  }
  
  public ProviderView a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int j = this.jdField_a_of_type_ArrayOfInt[i];
      ProviderView localProviderView = b(j);
      if (localProviderView != null)
      {
        localProviderView.b(null);
        localProviderView.setVisibility(8);
        addView(localProviderView);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localProviderView);
      }
      i += 1;
    }
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
    setVisibility(8);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.b();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_Int = 100;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).g();
    }
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setStickerListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
  
  public void setVideoSegmentPickerListener(VideoSegmentPickerProviderView.VideoSegmentPickerListener paramVideoSegmentPickerListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$VideoSegmentPickerListener = paramVideoSegmentPickerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */