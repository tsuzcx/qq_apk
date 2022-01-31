package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditVideoPermission
  extends EditVideoPart
{
  private int jdField_a_of_type_Int;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public EditVideoPermission(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private int a()
  {
    return 10000;
  }
  
  @NonNull
  private static List a(@NonNull List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      StoryReportor.a("pub_control", "clk_change", 0, 0, new String[] { String.valueOf(paramInt) });
      return;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString, ArrayList paramArrayList, List paramList)
  {
    if (paramList.contains(paramString)) {
      paramList.remove(paramString);
    }
    Object localObject = new ArrayList();
    switch (paramInt)
    {
    default: 
      paramArrayList = (ArrayList)localObject;
      paramInt = 0;
    }
    try
    {
      for (;;)
      {
        long l = Long.valueOf(paramString).longValue();
        if (paramArrayList.contains(Long.valueOf(l))) {
          paramArrayList.remove(Long.valueOf(l));
        }
        SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "permissionType:" + paramInt);
        SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "permissionUinList:" + paramArrayList.toString());
        SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "atUinList:" + paramList.toString());
        paramString = new qqstory_struct.VideoReaderConf();
        paramString.ban_type.set(paramInt);
        paramString.user_list.set(paramArrayList);
        paramString.setHasFlag(true);
        paramPublishVideoEntry.readerConfBytes = paramString.toByteArray();
        return;
        paramInt = 1000;
        paramArrayList = (ArrayList)localObject;
        continue;
        paramArrayList = (ArrayList)localObject;
        paramInt = 0;
        continue;
        String str;
        if (!paramList.isEmpty())
        {
          paramArrayList = paramList.iterator();
          while (paramArrayList.hasNext())
          {
            str = (String)paramArrayList.next();
            try
            {
              ((List)localObject).add(Long.valueOf(Long.valueOf(str).longValue()));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_ONLY_ME , can't format uin:%s", new Object[] { str });
            }
          }
          paramArrayList = (ArrayList)localObject;
          paramInt = 2;
        }
        else
        {
          paramArrayList = (ArrayList)localObject;
          paramInt = 1;
          continue;
          paramArrayList = a(paramArrayList);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            try
            {
              l = Long.valueOf(str).longValue();
              if (!paramArrayList.contains(Long.valueOf(l))) {
                paramArrayList.add(Long.valueOf(l));
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_CAN_SEE , can't format uin:%s", new Object[] { str });
            }
          }
          paramInt = 2;
          continue;
          paramArrayList = a(paramArrayList);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            try
            {
              l = Long.valueOf(str).longValue();
              if (paramArrayList.contains(Long.valueOf(l))) {
                paramArrayList.remove(Long.valueOf(l));
              }
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_CANNOT_SEE , can't format uin:%s", new Object[] { str });
            }
          }
          paramInt = 3;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "MyUin , can't format uin:%s", new Object[] { paramString });
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown type:%s", new Object[] { Integer.valueOf(paramInt) });
      paramInt = 1;
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b())
      {
      case 2: 
      default: 
        SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown entrance:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b()) });
        i = 99;
      }
      break;
    }
    for (;;)
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoPermission", "report select permission, permissionType:%s, entranceType:%s", Integer.valueOf(paramInt), Integer.valueOf(i));
      StoryReportor.a("pub_control", "clk_done", 0, 0, new String[] { String.valueOf(i), String.valueOf(paramInt) });
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      paramInt = 4;
      break;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  private void c()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, PermissionSettingActivity.class);
      localIntent.putExtra("PERMISSION_TYPE_KEY", this.b);
      localIntent.putStringArrayListExtra("PERMISSION_UIN_LIST_KEY", this.jdField_a_of_type_JavaUtilArrayList);
      localActivity.startActivityForResult(localIntent, 1);
    }
  }
  
  private void j()
  {
    switch (this.b)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843627);
      return;
    case 10004: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843630);
      return;
    case 10000: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843627);
      return;
    case 10001: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843634);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843635);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)a(2131364443));
    this.jdField_a_of_type_Int = a();
    this.b = this.jdField_a_of_type_Int;
    j();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    String str;
    Object localObject;
    if (paramInt1 == 1) {
      if ((paramInt2 == 1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("PERMISSION_TYPE_KEY", -2147483648);
        str = paramIntent.getStringExtra("PERMISSION_CURRENT_UIN_KEY");
        localObject = null;
        switch (paramInt1)
        {
        }
      }
    }
    for (paramIntent = localObject;; paramIntent = paramIntent.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY"))
    {
      this.b = paramInt1;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramIntent != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramIntent);
      }
      b(paramInt1);
      j();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "EditVideoPermission editVideoPrePublish....");
    ArrayList localArrayList = new ArrayList();
    EditVideoAtExport localEditVideoAtExport = (EditVideoAtExport)a(EditVideoAtExport.class);
    if (localEditVideoAtExport != null) {
      localArrayList.addAll(localEditVideoAtExport.a(paramInt));
    }
    a(paramGenerateContext.a, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, localArrayList);
    if ((paramInt == 0) && (this.b != this.jdField_a_of_type_Int))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "user has changed permission during editing session. default permission is %d, new permission is %d.", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b));
      a(this.b);
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      StoryReportor.a("pub_control", "clk_entry", 0, 0, new String[] { String.valueOf(paramInt) });
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        ((StoryConfigManager)SuperManager.a(10)).b("key_has_show_publish_permission_red_dot", Boolean.valueOf(true));
        StoryReportor.a("pub_control", "clk_buble_guide", 0, 0, new String[0]);
      }
      c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPermission
 * JD-Core Version:    0.7.0.1
 */