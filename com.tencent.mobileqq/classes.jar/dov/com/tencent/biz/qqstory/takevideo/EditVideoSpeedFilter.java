package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.filter.FilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer.PickerContainerListener;
import java.util.ArrayList;
import java.util.List;

public class EditVideoSpeedFilter
  extends EditVideoFilter
  implements PickerContainer.PickerContainerListener
{
  private static String jdField_a_of_type_JavaLangString = "EditVideoSpeedFilter";
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public PickerContainer a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public EditVideoSpeedFilter(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = b();
    }
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "EditVideoSpeedFilter : enable: " + this.jdField_c_of_type_Boolean);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int != 1) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 4) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 8));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(4);
  }
  
  private boolean b()
  {
    boolean bool1;
    StoryConfigManager localStoryConfigManager;
    if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
    {
      bool1 = true;
      if (!bool1) {
        SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's Meizu MX4 Pro, in backlist");
      }
      localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      if (localStoryConfigManager != null) {
        break label62;
      }
      SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "storyConfigManager == null !!!");
    }
    label62:
    boolean bool2;
    do
    {
      return bool1;
      bool1 = false;
      break;
      bool2 = bool1;
      if (bool1)
      {
        bool1 = ((Boolean)localStoryConfigManager.b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
        bool2 = bool1;
        if (!bool1)
        {
          SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool2 = bool1;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        bool2 = ((Boolean)localStoryConfigManager.b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
        bool1 = bool2;
        if (!bool2)
        {
          SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool1 = bool2;
        }
      }
      if (!bool1) {
        return bool1;
      }
      bool2 = ((Boolean)localStoryConfigManager.b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
      bool1 = bool2;
    } while (bool2);
    SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
    return bool2;
    return bool1;
  }
  
  private int c(int paramInt)
  {
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nSpeedIndex = " + paramInt);
    switch (paramInt)
    {
    case 5: 
    default: 
      return 1;
    case 4: 
      return 9;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 1: 
      return 8;
    }
    return 2;
  }
  
  private int d(int paramInt)
  {
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nPlayMode = " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2;
    case 9: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 8: 
      return 1;
    }
    return 5;
  }
  
  private void e(int paramInt, String paramString)
  {
    int k = 0;
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPlayModeChanged:" + paramInt + "  " + paramString);
    List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localList.size())
      {
        FilterData localFilterData = (FilterData)localList.get(i);
        if ((!TextUtils.isEmpty(localFilterData.jdField_a_of_type_JavaLangString)) && (localFilterData.jdField_a_of_type_Int == paramInt))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(i, false);
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          QQToast.a(a(), "不支持此种速度设置：" + paramString, 1000).a();
        }
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    super.a();
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364414));
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null);
    ViewParent localViewParent = this.jdField_a_of_type_AndroidViewViewStub.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {}
    for (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = ((PickerContainer)a(2131362513)))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(2, false);
      return;
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Boolean) {}
    switch (paramMessage.what)
    {
    default: 
      bool = super.a(paramMessage);
    }
    do
    {
      return bool;
      this.jdField_b_of_type_Int = paramMessage.arg1;
      int i = paramMessage.arg2;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
    paramMessage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer;
    if (this.jdField_b_of_type_Int == 1) {}
    for (bool = true;; bool = false)
    {
      paramMessage.a(bool, this.jdField_c_of_type_Long);
      return true;
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      a(true);
      return;
    case 28: 
      paramInt = d(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(paramInt, false);
      }
      a(true);
      return;
    }
    a(false);
  }
  
  public void b(int paramInt, String paramString)
  {
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeedStart:" + paramInt + "  " + paramString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c(int paramInt, String paramString)
  {
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeed:" + paramInt + "  " + paramString + " moving:" + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    e(c(paramInt), paramString);
  }
  
  public void d(int paramInt, String paramString)
  {
    SLog.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onSpeedPickEnd:" + paramInt + "  " + paramString);
    e(c(paramInt), paramString);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_AndroidViewViewStub = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = null;
    }
  }
  
  public void j()
  {
    SLog.a("Q.qqstory.publish.editEditVideoSpeedFilter", "updateFilterMode : %s", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource)))
    {
      localObject = (StoryConfigManager)SuperManager.a(10);
      localArrayList.add(new VideoEffectsFilterData("正常速度", -1, 0, 0));
      if (((Boolean)((StoryConfigManager)localObject).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue()) {
        break label316;
      }
      SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
      {
        if (((Boolean)((StoryConfigManager)localObject).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label361;
        }
        SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      label209:
      if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))
      {
        if (((Boolean)((StoryConfigManager)localObject).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label411;
        }
        SLog.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (localArrayList.isEmpty()) {}
    for (int i = 0;; i = ((FilterData)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label316:
      localArrayList.add(new VideoEffectsFilterData("快动作", 1, 0, 2));
      localArrayList.add(new VideoEffectsFilterData("稍快动作", 9, 0, 8));
      break;
      label361:
      localArrayList.add(new VideoEffectsFilterData("慢动作", 2, 0, 3));
      localArrayList.add(new VideoEffectsFilterData("极慢动作", 10, 0, 9));
      this.jdField_a_of_type_Boolean = true;
      break label209;
      label411:
      VideoEffectsFilterData localVideoEffectsFilterData = new VideoEffectsFilterData("倒带", 3, 0, 1);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.h()) {}
      for (localObject = "正在处理中...";; localObject = null)
      {
        localVideoEffectsFilterData.b = ((String)localObject);
        localArrayList.add(localVideoEffectsFilterData);
        break;
      }
    }
  }
  
  protected void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter
 * JD-Core Version:    0.7.0.1
 */