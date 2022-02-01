package dov.com.qq.im.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import bpnq;
import bpvt;
import bpwx;
import bpxa;
import bqrk;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import zps;

public class ProviderViewEditContainer
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 100;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bpnq jdField_a_of_type_Bpnq;
  private bpvt jdField_a_of_type_Bpvt;
  private bpwx jdField_a_of_type_Bpwx;
  private bpxa jdField_a_of_type_Bpxa;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int[] jdField_a_of_type_ArrayOfInt = { 103, 109, 111, 113 };
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
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject1 = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    Object localObject2;
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProviderViewEditContainer", 2, new Object[] { "openContainerProviderView view not exsist, id:", Integer.valueOf(paramInt) });
      }
      return false;
      localObject2 = b(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject2);
        addView((View)localObject2);
        localObject1 = localObject2;
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject1);
    switch (paramInt)
    {
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 112: 
    default: 
    case 103: 
    case 109: 
    case 110: 
      for (;;)
      {
        return true;
        localObject1 = (StaticStickerProviderView)localObject1;
        if (!((StaticStickerProviderView)localObject1).d())
        {
          ((StaticStickerProviderView)localObject1).a(null);
          ((StaticStickerProviderView)localObject1).setOnFaceSelectedListener(this.jdField_a_of_type_Bpnq);
        }
        ((StaticStickerProviderView)localObject1).setCaptureScene(this.b);
        ((StaticStickerProviderView)localObject1).i();
        ((StaticStickerProviderView)localObject1).c();
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          ((StaticStickerProviderView)localObject1).a((bqrk)paramVarArgs[0]);
        }
        paramVarArgs = getLayoutParams();
        paramInt = zps.a(getContext(), 206.0F);
        if (paramVarArgs.height != paramInt)
        {
          paramVarArgs.height = paramInt;
          setLayoutParams(paramVarArgs);
        }
        this.jdField_a_of_type_Int = 103;
        continue;
        localObject1 = (MusicFragmentProviderView)localObject1;
        if (!((MusicFragmentProviderView)localObject1).d())
        {
          ((MusicFragmentProviderView)localObject1).d(250);
          ((MusicFragmentProviderView)localObject1).a(null);
          if (this.jdField_a_of_type_Bpvt != null) {
            ((MusicFragmentProviderView)localObject1).setProviderViewListener(this.jdField_a_of_type_Bpvt);
          }
        }
        ((MusicFragmentProviderView)localObject1).setCaptureScene(this.b);
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          ((MusicFragmentProviderView)localObject1).setMusicProviderView((MusicItemInfo)paramVarArgs[0]);
        }
        paramVarArgs = getLayoutParams();
        paramInt = zps.a(getContext(), 250.0F);
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
        this.jdField_a_of_type_Int = 109;
        continue;
        paramVarArgs = (BgmRecognitionProviderView)localObject1;
        if (!paramVarArgs.d())
        {
          paramVarArgs.d(250);
          paramVarArgs.a(null);
          if (this.jdField_a_of_type_Bpvt != null) {
            paramVarArgs.setProviderViewListener(this.jdField_a_of_type_Bpvt);
          }
        }
        paramVarArgs.setCaptureScene(this.b);
        paramVarArgs.c();
        paramVarArgs = getLayoutParams();
        paramInt = zps.a(getContext(), 250.0F);
        if (paramVarArgs.height != paramInt)
        {
          paramVarArgs.height = paramInt;
          setLayoutParams(paramVarArgs);
        }
        this.jdField_a_of_type_Int = 110;
      }
    case 111: 
      localObject1 = (VideoSegmentPickerProviderView)localObject1;
      if (!((VideoSegmentPickerProviderView)localObject1).d())
      {
        ((VideoSegmentPickerProviderView)localObject1).setCaptureScene(this.b);
        ((VideoSegmentPickerProviderView)localObject1).setListener(this.jdField_a_of_type_Bpxa);
        ((VideoSegmentPickerProviderView)localObject1).a(null);
      }
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
        break;
      }
    }
    for (paramInt = ((VideoSegmentPickerProviderView)localObject1).b() + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();; paramInt = 0)
    {
      localObject2 = getLayoutParams();
      int i = zps.a(getContext(), 95.0F);
      if (paramInt > 0) {}
      for (((ViewGroup.LayoutParams)localObject2).height = paramInt;; ((ViewGroup.LayoutParams)localObject2).height = i)
      {
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bqrk)))
        {
          ((VideoSegmentPickerProviderView)localObject1).setItems((bqrk)paramVarArgs[0]);
          ((VideoSegmentPickerProviderView)localObject1).c();
        }
        this.jdField_a_of_type_Int = 111;
        break;
      }
      localObject1 = (VideoCoverPickerProviderView)localObject1;
      if (!((VideoCoverPickerProviderView)localObject1).d())
      {
        ((VideoCoverPickerProviderView)localObject1).setCaptureScene(this.b);
        ((VideoCoverPickerProviderView)localObject1).setListener(this.jdField_a_of_type_Bpwx);
        ((VideoCoverPickerProviderView)localObject1).a(null);
      }
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Long))) {
        ((VideoCoverPickerProviderView)localObject1).setCoverFrameTime(((Long)paramVarArgs[0]).longValue());
      }
      paramVarArgs = getLayoutParams();
      i = zps.a(getContext(), 185.0F);
      paramInt = i;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramInt = i + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      }
      paramVarArgs.height = paramInt;
      setLayoutParams(paramVarArgs);
      this.jdField_a_of_type_Int = 113;
      break;
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
    case 112: 
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
    case 111: 
      localObject = new VideoSegmentPickerProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    }
    Object localObject = new VideoCoverPickerProviderView(getContext());
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
    setVisibility(8);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_Int == 111)) {
        setBackgroundColor(2131165356);
      }
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
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
      setVisibility(0);
    } while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Int != 111));
    setBackgroundColor(0);
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
  
  public void setProviderViewListener(bpvt parambpvt)
  {
    this.jdField_a_of_type_Bpvt = parambpvt;
  }
  
  public void setStickerListener(bpnq parambpnq)
  {
    this.jdField_a_of_type_Bpnq = parambpnq;
  }
  
  public void setVideoCoverPickerListener(bpwx parambpwx)
  {
    this.jdField_a_of_type_Bpwx = parambpwx;
  }
  
  public void setVideoSegmentPickerListener(bpxa parambpxa)
  {
    this.jdField_a_of_type_Bpxa = parambpxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */