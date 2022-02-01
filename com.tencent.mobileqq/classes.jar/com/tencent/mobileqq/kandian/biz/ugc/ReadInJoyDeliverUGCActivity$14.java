package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
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
    localReadInJoyDraftboxContent.typeList = ReadInJoyDeliverUGCActivity.e(this.this$0);
    ReadInJoyDeliverUGCActivity.a(this.this$0, new ArrayList());
    Utils.a(this.this$0.e, this.this$0.app.getCurrentAccountUin(), this.this$0.S, ReadInJoyDeliverUGCActivity.n(this.this$0));
    Object localObject1 = this.this$0;
    ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject1, ReadInJoyDeliverUGCActivity.n((ReadInJoyDeliverUGCActivity)localObject1), ReadInJoyDeliverUGCActivity.o(this.this$0));
    localReadInJoyDraftboxContent.multiBiuStruct = ReadInJoyDeliverUGCActivity.n(this.this$0);
    localReadInJoyDraftboxContent.srcSize = ReadInJoyDeliverUGCActivity.p(this.this$0);
    localReadInJoyDraftboxContent.commentString = this.this$0.e.getEditableText().toString();
    localReadInJoyDraftboxContent.adTag = this.this$0.J;
    localReadInJoyDraftboxContent.ugcEditCookie = ReadInJoyDeliverUGCActivity.q(this.this$0);
    localReadInJoyDraftboxContent.topicId = this.this$0.G;
    if ((ReadInJoyDeliverUGCActivity.b(this.this$0).b() != null) && (ReadInJoyDeliverUGCActivity.b(this.this$0).b().size() > 1))
    {
      localReadInJoyDraftboxContent.adapterList = new ArrayList();
      localObject1 = ReadInJoyDeliverUGCActivity.b(this.this$0).b().subList(0, ReadInJoyDeliverUGCActivity.b(this.this$0).getCount() - 1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        ReadInJoyDraftboxItem.PicData localPicData = new ReadInJoyDraftboxItem.PicData();
        if ((localObject2 instanceof HotPicData))
        {
          localPicData.a = ((HotPicData)localObject2);
          localPicData.c = 0;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else if ((localObject2 instanceof String))
        {
          localPicData.b = ((String)localObject2);
          localPicData.c = 1;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else
        {
          localReadInJoyDraftboxContent.adapterList.add(null);
        }
      }
    }
    if (this.this$0.V != null)
    {
      localObject1 = this.this$0;
      ((ReadInJoyDeliverUGCActivity)localObject1).W = ((ReadInJoyDeliverUGCActivity)localObject1).V.a(this.this$0.W, localReadInJoyDraftboxContent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.14
 * JD-Core Version:    0.7.0.1
 */