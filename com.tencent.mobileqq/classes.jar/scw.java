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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class scw
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<scy> jdField_a_of_type_JavaUtilList;
  private Queue<rsd> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private ofc jdField_a_of_type_Ofc;
  private ofd jdField_a_of_type_Ofd;
  private rsd jdField_a_of_type_Rsd;
  private rsq jdField_a_of_type_Rsq;
  private scz jdField_a_of_type_Scz;
  private sda jdField_a_of_type_Sda;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private rsd jdField_b_of_type_Rsd;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private rsd jdField_c_of_type_Rsd;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public scw(Activity paramActivity, FrameLayout paramFrameLayout, sda paramsda)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Sda = paramsda;
    this.jdField_a_of_type_AndroidOsHandler = new bjng(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = pay.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Ofc = ((ofc)paramActivity.getBusinessHandler(90));
      this.jdField_a_of_type_Ofd = new sdb(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.getCurrentUin();
    }
  }
  
  private void a(rsd paramrsd1, rsd paramrsd2)
  {
    if (((paramrsd1 instanceof sdg)) && ((paramrsd2 instanceof sdg)))
    {
      paramrsd1 = (sdg)paramrsd1;
      paramrsd2 = (sdg)paramrsd2;
    }
    try
    {
      paramrsd2 = paramrsd2.a;
      if (paramrsd2 != null)
      {
        paramrsd2.mChannelID = paramrsd1.a.mChannelID;
        paramrsd2.mRecommendTime = paramrsd1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramrsd1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramrsd1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Ofc != null) && (this.jdField_b_of_type_Rsd != null)) {
      this.jdField_a_of_type_Ofc.a(this.jdField_a_of_type_Ofd, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Rsd.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ofd != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Ofd);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Rsd.jdField_a_of_type_Int = (this.jdField_b_of_type_Rsd.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Rsd, this.jdField_c_of_type_Rsd);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Rsd != null) && (this.jdField_a_of_type_Rsq != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Rsd);
      if (this.jdField_a_of_type_Scz != null) {
        this.jdField_a_of_type_Scz.a(this.jdField_b_of_type_Rsd, this.jdField_c_of_type_Rsd, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Rsq.a(this.jdField_c_of_type_Rsd);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Rsd = null;
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
        scy localscy = (scy)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localscy.jdField_a_of_type_Rsd.a());
        localJSONObject2.put("playCount", localscy.jdField_a_of_type_Int);
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
  
  public List<scy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public rsd a()
  {
    return this.jdField_b_of_type_Rsd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Rsd != null) {
      this.jdField_a_of_type_JavaUtilList.add(new scy(this.jdField_b_of_type_Rsd, this.jdField_d_of_type_Int));
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
    if (this.jdField_c_of_type_Rsd != null)
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
  
  public void a(rsd paramrsd)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramrsd + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ofd != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Ofd);
      }
      if ((paramrsd != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Rsd = paramrsd;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramrsd.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(uet.a(paramrsd.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramrsd = new sie(null, null, paramrsd.c, paramrsd.a()).a((int)paramrsd.jdField_b_of_type_Long).a().a();
      odq.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramrsd, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(rsd paramrsd, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramrsd);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Rsd = paramrsd;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Rsd != null)
    {
      if (paramrsd.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramrsd.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(rsq paramrsq)
  {
    this.jdField_a_of_type_Rsq = paramrsq;
  }
  
  public void a(scz paramscz)
  {
    this.jdField_a_of_type_Scz = paramscz;
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
  
  public void b(rsd paramrsd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramrsd);
    }
    this.jdField_c_of_type_Rsd = paramrsd;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramrsd);
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
    this.jdField_a_of_type_Ofc = null;
  }
  
  public void f()
  {
    rsd localrsd = (rsd)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localrsd == null)
    {
      g();
      return;
    }
    b(localrsd);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      if (this.jdField_a_of_type_Rsq != null) {
        this.jdField_a_of_type_Rsq.a(this.jdField_a_of_type_Rsd);
      }
      if (this.jdField_a_of_type_Rsd != null)
      {
        String str = new sie(null, null, this.jdField_a_of_type_Rsd.c, this.jdField_a_of_type_Rsd.a()).a((int)this.jdField_a_of_type_Rsd.jdField_b_of_type_Long).a().a();
        odq.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
        continue;
        if (this.jdField_a_of_type_Scz != null)
        {
          this.jdField_a_of_type_Scz.j();
          continue;
          if (this.jdField_c_of_type_Rsd != null)
          {
            str = new sie(null, null, this.jdField_c_of_type_Rsd.c, this.jdField_c_of_type_Rsd.a()).a((int)this.jdField_c_of_type_Rsd.jdField_b_of_type_Long).i(this.jdField_c_of_type_Rsd.a()).a().a();
            odq.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
            b();
            j();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scw
 * JD-Core Version:    0.7.0.1
 */