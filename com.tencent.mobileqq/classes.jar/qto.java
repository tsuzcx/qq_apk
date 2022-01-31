import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class qto
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<qtq> jdField_a_of_type_JavaUtilList;
  private Queue<qjl> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private npv jdField_a_of_type_Npv;
  private npw jdField_a_of_type_Npw;
  private qjl jdField_a_of_type_Qjl;
  private qju jdField_a_of_type_Qju;
  private qtr jdField_a_of_type_Qtr;
  private qts jdField_a_of_type_Qts;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private qjl jdField_b_of_type_Qjl;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private qjl jdField_c_of_type_Qjl;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public qto(Activity paramActivity, FrameLayout paramFrameLayout, qts paramqts)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Qts = paramqts;
    this.jdField_a_of_type_AndroidOsHandler = new bfnk(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = onk.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Npv = ((npv)paramActivity.a(90));
      this.jdField_a_of_type_Npw = new qtt(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.c();
    }
  }
  
  private void a(qjl paramqjl1, qjl paramqjl2)
  {
    if (((paramqjl1 instanceof qty)) && ((paramqjl2 instanceof qty)))
    {
      paramqjl1 = (qty)paramqjl1;
      paramqjl2 = (qty)paramqjl2;
    }
    try
    {
      paramqjl2 = paramqjl2.a;
      if (paramqjl2 != null)
      {
        paramqjl2.mChannelID = paramqjl1.a.mChannelID;
        paramqjl2.mRecommendTime = paramqjl1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramqjl1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramqjl1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Npv != null) && (this.jdField_b_of_type_Qjl != null)) {
      this.jdField_a_of_type_Npv.a(this.jdField_a_of_type_Npw, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Qjl.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Npw != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Npw);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Qjl.jdField_a_of_type_Int = (this.jdField_b_of_type_Qjl.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Qjl, this.jdField_c_of_type_Qjl);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Qjl != null) && (this.jdField_a_of_type_Qju != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Qjl);
      if (this.jdField_a_of_type_Qtr != null) {
        this.jdField_a_of_type_Qtr.a(this.jdField_b_of_type_Qjl, this.jdField_c_of_type_Qjl, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Qju.a(this.jdField_c_of_type_Qjl);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Qjl = null;
    this.e = false;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_c_of_type_Int);
  }
  
  public String a(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qtq localqtq = (qtq)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localqtq.jdField_a_of_type_Qjl.a());
        localJSONObject2.put("playCount", localqtq.jdField_a_of_type_Int);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    localJSONObject1.put("first_rowKey", paramString);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  public qjl a()
  {
    return this.jdField_b_of_type_Qjl;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Qjl != null) {
      this.jdField_a_of_type_JavaUtilList.add(new qtq(this.jdField_b_of_type_Qjl, this.jdField_d_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!b()) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.jdField_c_of_type_Qjl != null)
    {
      b();
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(qjl paramqjl)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!bbev.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramqjl + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Npw != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Npw);
      }
      if ((paramqjl != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Qjl = paramqjl;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramqjl.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(sfd.a(paramqjl.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramqjl = new qze(null, null, paramqjl.c, paramqjl.a()).a((int)paramqjl.jdField_b_of_type_Long).a().a();
      noo.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramqjl, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(qjl paramqjl, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramqjl);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Qjl = paramqjl;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Qjl != null)
    {
      if (paramqjl.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramqjl.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(qju paramqju)
  {
    this.jdField_a_of_type_Qju = paramqju;
  }
  
  public void a(qtr paramqtr)
  {
    this.jdField_a_of_type_Qtr = paramqtr;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
    h();
  }
  
  public void b(qjl paramqjl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramqjl);
    }
    this.jdField_c_of_type_Qjl = paramqjl;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramqjl);
    if (!this.jdField_c_of_type_Boolean) {
      a(3);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void e()
  {
    h();
    this.jdField_a_of_type_Npv = null;
  }
  
  public void f()
  {
    qjl localqjl = (qjl)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localqjl == null)
    {
      g();
      return;
    }
    b(localqjl);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        a(paramMessage.arg1);
      }
    }
    else
    {
      return true;
    }
    a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          b();
          if (this.jdField_a_of_type_Qju != null) {
            this.jdField_a_of_type_Qju.a(this.jdField_a_of_type_Qjl);
          }
        } while (this.jdField_a_of_type_Qjl == null);
        paramView = new qze(null, null, this.jdField_a_of_type_Qjl.c, this.jdField_a_of_type_Qjl.a()).a((int)this.jdField_a_of_type_Qjl.jdField_b_of_type_Long).a().a();
        noo.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
        return;
      } while (this.jdField_a_of_type_Qtr == null);
      this.jdField_a_of_type_Qtr.j();
      return;
    } while (this.jdField_c_of_type_Qjl == null);
    paramView = new qze(null, null, this.jdField_c_of_type_Qjl.c, this.jdField_c_of_type_Qjl.a()).a((int)this.jdField_c_of_type_Qjl.jdField_b_of_type_Long).h(this.jdField_c_of_type_Qjl.a()).a().a();
    noo.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
    b();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qto
 * JD-Core Version:    0.7.0.1
 */