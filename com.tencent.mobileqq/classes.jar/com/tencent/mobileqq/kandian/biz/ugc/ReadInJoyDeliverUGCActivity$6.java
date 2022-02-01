package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.mobileqq.text.QQText;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDeliverUGCActivity$6
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$6(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    if (this.this$0.Y != null)
    {
      Object localObject = this.this$0;
      ((ReadInJoyDeliverUGCActivity)localObject).G = ((ReadInJoyDeliverUGCActivity)localObject).Y.topicId;
      localObject = this.this$0;
      ((ReadInJoyDeliverUGCActivity)localObject).J = ((ReadInJoyDeliverUGCActivity)localObject).Y.adTag;
      localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).Y.ugcEditCookie);
      localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).Y.multiBiuStruct);
      ReadInJoyDeliverUGCActivity.g(this.this$0);
      if ((this.this$0.Y.adapterList != null) && (this.this$0.Y.adapterList.size() > 0))
      {
        localObject = new ArrayList();
        Iterator localIterator = this.this$0.Y.adapterList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem.PicData localPicData = (ReadInJoyDraftboxItem.PicData)localIterator.next();
          if (localPicData != null) {
            if (localPicData.a != null) {
              ((List)localObject).add(localPicData.a);
            } else if ((!TextUtils.isEmpty(localPicData.b)) && (new File(localPicData.b).exists())) {
              ((List)localObject).add(localPicData.b);
            }
          }
        }
        if (((List)localObject).size() > 0) {
          ReadInJoyDeliverUGCActivity.a(this.this$0, (List)localObject);
        }
      }
      int i = this.this$0.getResources().getDisplayMetrics().widthPixels;
      int j = this.this$0.e.getPaddingLeft();
      int k = this.this$0.e.getPaddingRight();
      localObject = this.this$0;
      localObject = ((ReadInJoyDeliverUGCActivity)localObject).a(((ReadInJoyDeliverUGCActivity)localObject).Y.multiBiuStruct, this.this$0.getBaseContext(), this.this$0.e, i - j - k);
      if (localObject != null)
      {
        this.this$0.e.getEditableText().clear();
        this.this$0.e.getEditableText().insert(0, new QQText((CharSequence)localObject, 7));
      }
      if ((ReadInJoyDeliverUGCActivity.d(this.this$0) <= 0) && (this.this$0.e.getText().toString().length() <= 0))
      {
        this.this$0.a(false);
        return;
      }
      this.this$0.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.6
 * JD-Core Version:    0.7.0.1
 */