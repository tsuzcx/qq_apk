package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.EditText;
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
    if (this.this$0.b != null)
    {
      Object localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).b.topicId);
      localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.b((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).b.adTag);
      localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.b((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).b.ugcEditCookie);
      localObject = this.this$0;
      ReadInJoyDeliverUGCActivity.a((ReadInJoyDeliverUGCActivity)localObject, ((ReadInJoyDeliverUGCActivity)localObject).b.multiBiuStruct);
      ReadInJoyDeliverUGCActivity.b(this.this$0);
      if ((this.this$0.b.adapterList != null) && (this.this$0.b.adapterList.size() > 0))
      {
        localObject = new ArrayList();
        Iterator localIterator = this.this$0.b.adapterList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem.PicData localPicData = (ReadInJoyDraftboxItem.PicData)localIterator.next();
          if (localPicData != null) {
            if (localPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
              ((List)localObject).add(localPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData);
            } else if ((!TextUtils.isEmpty(localPicData.jdField_a_of_type_JavaLangString)) && (new File(localPicData.jdField_a_of_type_JavaLangString).exists())) {
              ((List)localObject).add(localPicData.jdField_a_of_type_JavaLangString);
            }
          }
        }
        if (((List)localObject).size() > 0) {
          ReadInJoyDeliverUGCActivity.a(this.this$0, (List)localObject);
        }
      }
      int i = this.this$0.getResources().getDisplayMetrics().widthPixels;
      int j = this.this$0.a.getPaddingLeft();
      int k = this.this$0.a.getPaddingRight();
      localObject = this.this$0;
      localObject = ((ReadInJoyDeliverUGCActivity)localObject).a(((ReadInJoyDeliverUGCActivity)localObject).b.multiBiuStruct, this.this$0.getBaseContext(), this.this$0.a, i - j - k);
      if (localObject != null)
      {
        this.this$0.a.getEditableText().clear();
        this.this$0.a.getEditableText().insert(0, new QQText((CharSequence)localObject, 7));
      }
      if ((ReadInJoyDeliverUGCActivity.a(this.this$0) <= 0) && (this.this$0.a.getText().toString().length() <= 0))
      {
        this.this$0.a(false);
        return;
      }
      this.this$0.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.6
 * JD-Core Version:    0.7.0.1
 */