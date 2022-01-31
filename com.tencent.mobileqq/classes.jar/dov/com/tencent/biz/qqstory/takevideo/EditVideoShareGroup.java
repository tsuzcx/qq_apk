package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.widget.TextView;
import aney;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditVideoShareGroup
  extends EditVideoPart
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public EditVideoShareGroup(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("shareGroupId");
    this.b = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("shareGroupName");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("ignorePersonalPublish", false);
    SLog.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s", this.jdField_a_of_type_JavaLangString, this.b, Boolean.valueOf(this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364424));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aney(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      SLog.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramGenerateContext.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramGenerateContext.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramGenerateContext.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        SLog.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString, this.b });
        paramGenerateContext.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          SLog.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoShareGroup
 * JD-Core Version:    0.7.0.1
 */