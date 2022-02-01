package com.tencent.mobileqq.kandian.glue.viola.comment;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

class KdCommentList$1
  implements Runnable
{
  KdCommentList$1(KdCommentList paramKdCommentList, JSONObject paramJSONObject1, JSONObject paramJSONObject2, View paramView) {}
  
  public void run()
  {
    KdCommentList localKdCommentList1 = this.this$0;
    ReadInJoyCommentHelper localReadInJoyCommentHelper = new ReadInJoyCommentHelper();
    String str = KdCommentList.access$100(this.this$0, this.jdField_a_of_type_OrgJsonJSONObject, this.b).toString();
    KdCommentList localKdCommentList2 = this.this$0;
    KdCommentList.access$002(localKdCommentList1, localReadInJoyCommentHelper.a(str, localKdCommentList2, localKdCommentList2));
    if ((this.this$0.getInstance() != null) && ((this.this$0.getInstance().getActivity() instanceof QBaseActivity)) && (KdCommentList.access$000(this.this$0) != null))
    {
      ((QBaseActivity)this.this$0.getInstance().getActivity()).getSupportFragmentManager().beginTransaction().add(this.jdField_a_of_type_AndroidViewView.getId(), KdCommentList.access$000(this.this$0)).commitAllowingStateLoss();
      RIJCommentResultDispatcher.a().a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentList.1
 * JD-Core Version:    0.7.0.1
 */