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

public class tfd
  extends pvq
{
  public tfd(FastWebActivity paramFastWebActivity) {}
  
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
    tjw.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.d(this.a);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    for (String str = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;; str = "")
    {
      if ((TextUtils.isEmpty(str)) || (FastWebActivity.a(this.a) == null)) {
        return;
      }
      paramArrayList = tjm.a(str, 23, paramArrayList);
      int i = 0;
      while (i < paramArrayList.size())
      {
        BaseData localBaseData = (BaseData)paramArrayList.get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          tjm.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (ProteusItemData)localBaseData, 3, this.a.jdField_a_of_type_AndroidUtilSparseArray);
        }
        tke.b(FastWebActivity.a(this.a), localBaseData, FastWebActivity.a(this.a));
        i += 1;
      }
      paramArrayList = pvj.a().a();
      if (paramArrayList != null) {
        paramArrayList.a(str, FastWebActivity.a(this.a));
      }
      FastWebActivity.d(this.a);
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
      return;
    }
  }
  
  public void aj_()
  {
    super.aj_();
    if ((FastWebActivity.c(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.d(this.a);
  }
  
  public void b(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.26.2(this, paramList, paramList1));
  }
  
  public void g()
  {
    super.g();
    if ((FastWebActivity.d(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    tjf.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a));
    FastWebActivity.h(this.a);
    FastWebActivity.d(this.a);
  }
  
  public void h()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.h(this.a);
    FastWebActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfd
 * JD-Core Version:    0.7.0.1
 */