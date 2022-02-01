package com.tencent.mobileqq.kandian.biz.ugc;

import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDeliverUGCActivity$14
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$14(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent = new ReadInJoyDraftboxItem.ReadInJoyDraftboxContent();
    localReadInJoyDraftboxContent.typeList = ReadInJoyDeliverUGCActivity.a(this.this$0);
    ReadInJoyDeliverUGCActivity.a(this.this$0, new ArrayList());
    Utils.a(this.this$0.jdField_a_of_type_AndroidWidgetEditText, this.this$0.app.getCurrentAccountUin(), this.this$0.o, ReadInJoyDeliverUGCActivity.a(this.this$0));
    Object localObject1 = this.this$0;
    ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject1, ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject1), ReadInJoyDeliverUGCActivity.a(this.this$0));
    localReadInJoyDraftboxContent.multiBiuStruct = ReadInJoyDeliverUGCActivity.a(this.this$0);
    localReadInJoyDraftboxContent.srcSize = ReadInJoyDeliverUGCActivity.b(this.this$0);
    localReadInJoyDraftboxContent.commentString = this.this$0.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    localReadInJoyDraftboxContent.adTag = ReadInJoyDeliverUGCActivity.c(this.this$0);
    localReadInJoyDraftboxContent.ugcEditCookie = ReadInJoyDeliverUGCActivity.b(this.this$0);
    localReadInJoyDraftboxContent.topicId = ReadInJoyDeliverUGCActivity.c(this.this$0);
    if ((ReadInJoyDeliverUGCActivity.a(this.this$0).a() != null) && (ReadInJoyDeliverUGCActivity.a(this.this$0).a().size() > 1))
    {
      localReadInJoyDraftboxContent.adapterList = new ArrayList();
      localObject1 = ReadInJoyDeliverUGCActivity.a(this.this$0).a().subList(0, ReadInJoyDeliverUGCActivity.a(this.this$0).getCount() - 1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        ReadInJoyDraftboxItem.PicData localPicData = new ReadInJoyDraftboxItem.PicData();
        if ((localObject2 instanceof HotPicData))
        {
          localPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = ((HotPicData)localObject2);
          localPicData.jdField_a_of_type_Int = 0;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else if ((localObject2 instanceof String))
        {
          localPicData.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localPicData.jdField_a_of_type_Int = 1;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else
        {
          localReadInJoyDraftboxContent.adapterList.add(null);
        }
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule != null)
    {
      localObject1 = this.this$0;
      ((ReadInJoyDeliverUGCActivity)localObject1).jdField_a_of_type_Long = ((ReadInJoyDeliverUGCActivity)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule.a(this.this$0.jdField_a_of_type_Long, localReadInJoyDraftboxContent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.14
 * JD-Core Version:    0.7.0.1
 */