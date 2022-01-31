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

public class qhj
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<qhl> jdField_a_of_type_JavaUtilList;
  private Queue<pxn> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private neu jdField_a_of_type_Neu;
  private nev jdField_a_of_type_Nev;
  private pxn jdField_a_of_type_Pxn;
  private pxv jdField_a_of_type_Pxv;
  private qhm jdField_a_of_type_Qhm;
  private qhn jdField_a_of_type_Qhn;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private pxn jdField_b_of_type_Pxn;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private pxn jdField_c_of_type_Pxn;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public qhj(Activity paramActivity, FrameLayout paramFrameLayout, qhn paramqhn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Qhn = paramqhn;
    this.jdField_a_of_type_AndroidOsHandler = new befq(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = obz.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Neu = ((neu)paramActivity.a(90));
      this.jdField_a_of_type_Nev = new qho(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.c();
    }
  }
  
  private void a(pxn parampxn1, pxn parampxn2)
  {
    if (((parampxn1 instanceof qht)) && ((parampxn2 instanceof qht)))
    {
      parampxn1 = (qht)parampxn1;
      parampxn2 = (qht)parampxn2;
    }
    try
    {
      parampxn2 = parampxn2.a;
      if (parampxn2 != null)
      {
        parampxn2.mChannelID = parampxn1.a.mChannelID;
        parampxn2.mRecommendTime = parampxn1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable parampxn1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + parampxn1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Neu != null) && (this.jdField_b_of_type_Pxn != null)) {
      this.jdField_a_of_type_Neu.a(this.jdField_a_of_type_Nev, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Pxn.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Nev != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Nev);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Pxn.jdField_a_of_type_Int = (this.jdField_b_of_type_Pxn.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Pxn, this.jdField_c_of_type_Pxn);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Pxn != null) && (this.jdField_a_of_type_Pxv != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Pxn);
      if (this.jdField_a_of_type_Qhm != null) {
        this.jdField_a_of_type_Qhm.a(this.jdField_b_of_type_Pxn, this.jdField_c_of_type_Pxn, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Pxv.a(this.jdField_c_of_type_Pxn);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Pxn = null;
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
        qhl localqhl = (qhl)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localqhl.jdField_a_of_type_Pxn.a());
        localJSONObject2.put("playCount", localqhl.jdField_a_of_type_Int);
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
  
  public pxn a()
  {
    return this.jdField_b_of_type_Pxn;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Pxn != null) {
      this.jdField_a_of_type_JavaUtilList.add(new qhl(this.jdField_b_of_type_Pxn, this.jdField_d_of_type_Int));
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
    if (this.jdField_c_of_type_Pxn != null)
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
  
  public void a(pxn parampxn)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!badq.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + parampxn + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Nev != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Nev);
      }
      if ((parampxn != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Pxn = parampxn;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(parampxn.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(rsl.a(parampxn.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      parampxn = new qmv(null, null, parampxn.c, parampxn.a()).a((int)parampxn.jdField_b_of_type_Long).a().a();
      ndn.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", parampxn, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(pxn parampxn, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + parampxn);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Pxn = parampxn;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Pxn != null)
    {
      if (parampxn.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (parampxn.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(pxv parampxv)
  {
    this.jdField_a_of_type_Pxv = parampxv;
  }
  
  public void a(qhm paramqhm)
  {
    this.jdField_a_of_type_Qhm = paramqhm;
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
  
  public void b(pxn parampxn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + parampxn);
    }
    this.jdField_c_of_type_Pxn = parampxn;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(parampxn);
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
    this.jdField_a_of_type_Neu = null;
  }
  
  public void f()
  {
    pxn localpxn = (pxn)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localpxn == null)
    {
      g();
      return;
    }
    b(localpxn);
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
          if (this.jdField_a_of_type_Pxv != null) {
            this.jdField_a_of_type_Pxv.a(this.jdField_a_of_type_Pxn);
          }
        } while (this.jdField_a_of_type_Pxn == null);
        paramView = new qmv(null, null, this.jdField_a_of_type_Pxn.c, this.jdField_a_of_type_Pxn.a()).a((int)this.jdField_a_of_type_Pxn.jdField_b_of_type_Long).a().a();
        ndn.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
        return;
      } while (this.jdField_a_of_type_Qhm == null);
      this.jdField_a_of_type_Qhm.j();
      return;
    } while (this.jdField_c_of_type_Pxn == null);
    paramView = new qmv(null, null, this.jdField_c_of_type_Pxn.c, this.jdField_c_of_type_Pxn.a()).a((int)this.jdField_c_of_type_Pxn.jdField_b_of_type_Long).h(this.jdField_c_of_type_Pxn.a()).a().a();
    ndn.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
    b();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhj
 * JD-Core Version:    0.7.0.1
 */