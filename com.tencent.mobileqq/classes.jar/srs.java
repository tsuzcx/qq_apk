import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

public class srs
  extends pkt
{
  public srs(FastWebActivity paramFastWebActivity) {}
  
  public void a(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.e(this.a)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.26.1(this), i);
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
    swl.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.c(this.a);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    for (String str = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;; str = "")
    {
      if ((TextUtils.isEmpty(str)) || (FastWebActivity.a(this.a) == null)) {
        return;
      }
      paramArrayList = swb.a(str, 23, paramArrayList);
      int i = 0;
      while (i < paramArrayList.size())
      {
        BaseData localBaseData = (BaseData)paramArrayList.get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          swb.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (ProteusItemData)localBaseData, 3, this.a.jdField_a_of_type_AndroidUtilSparseArray);
        }
        swt.b(FastWebActivity.a(this.a), localBaseData, FastWebActivity.a(this.a));
        i += 1;
      }
      paramArrayList = pkm.a().a();
      if (paramArrayList != null) {
        paramArrayList.a(str, FastWebActivity.a(this.a));
      }
      FastWebActivity.c(this.a);
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
      return;
    }
  }
  
  public void ah_()
  {
    super.ah_();
    if ((FastWebActivity.c(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.c(this.a);
  }
  
  public void b(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.26.2(this, paramList, paramList1));
  }
  
  public void e()
  {
    super.e();
    if ((FastWebActivity.d(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    svu.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a));
    FastWebActivity.g(this.a);
    FastWebActivity.c(this.a);
  }
  
  public void f()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.g(this.a);
    FastWebActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srs
 * JD-Core Version:    0.7.0.1
 */