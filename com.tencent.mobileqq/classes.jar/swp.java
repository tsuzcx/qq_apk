import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.27.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.27.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.27.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.27.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

public class swp
  extends pmn
{
  public swp(FastWebActivity paramFastWebActivity) {}
  
  public void a(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.h(this.a)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.27.2(this), i);
      return;
      i = j;
      if ("onConversationJumpRestoreStack".equals(paramString)) {
        i = j;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    tbp.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Object localObject = tbf.a(23, paramArrayList);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    for (paramArrayList = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;; paramArrayList = "")
    {
      if ((TextUtils.isEmpty(paramArrayList)) || (FastWebActivity.a(this.a) == null)) {
        return;
      }
      int i = 0;
      while (i < ((List)localObject).size())
      {
        BaseData localBaseData = (BaseData)((List)localObject).get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          tbf.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (ProteusItemData)localBaseData, 3, this.a.jdField_a_of_type_AndroidUtilSparseArray);
        }
        tbx.b(FastWebActivity.a(this.a), localBaseData, FastWebActivity.a(this.a));
        i += 1;
      }
      localObject = pmh.a().a();
      if (localObject != null) {
        ((pwt)localObject).a(paramArrayList, FastWebActivity.a(this.a));
      }
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).notifyDataSetChanged();
      }
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      FastWebActivity.a(this.a).postDelayed(new FastWebActivity.27.3(this, arrayOfInt, paramString), 200L);
      return;
    }
    QLog.i("FastWebActivity", 1, " red packet task do not get Tips!");
  }
  
  public void as_()
  {
    super.as_();
    if ((FastWebActivity.f(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    this.a.runOnUiThread(new FastWebActivity.27.1(this));
  }
  
  public void b(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.27.4(this, paramList, paramList1));
  }
  
  public void e()
  {
    super.e();
    if ((FastWebActivity.g(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).a);
    FastWebActivity.g(this.a);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void f()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.g(this.a);
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swp
 * JD-Core Version:    0.7.0.1
 */