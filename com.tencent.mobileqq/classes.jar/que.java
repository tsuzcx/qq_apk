import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class que
  implements qui
{
  private static Set<KandianMsgBoxRedPntInfo> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  
  public que(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    c();
  }
  
  public static void a(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaUtilSet;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b(false, paramInt, (KandianMsgBoxRedPntInfo)((Iterator)localObject).next());
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt, KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    ocg localocg = new ocg();
    for (;;)
    {
      try
      {
        localocg.k(1037);
        localocg.a(0);
        localocg.a("message_type", String.valueOf(paramKandianMsgBoxRedPntInfo.messageType));
        localocg.a("feedsid", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsID));
        localocg.a("feedstype", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsType));
        if (paramKandianMsgBoxRedPntInfo.mMsgType == 2)
        {
          localocg.a("sys_msg_id", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgID));
          localocg.a("sys_msg_from", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgFrom));
        }
        localocg.a("reddot_num", String.valueOf(paramKandianMsgBoxRedPntInfo.mMsgCnt));
        localocg.b("msgbox1000000000");
        if (paramBoolean) {
          break label220;
        }
        localocg.a("behavior_type", String.valueOf(paramInt));
      }
      catch (Exception paramKandianMsgBoxRedPntInfo)
      {
        QLog.e("ReadinjoySocialMsgCard", 1, "report has error " + paramKandianMsgBoxRedPntInfo);
        return;
      }
      ndn.a(null, "CliOper", "", String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), str, str, 0, 0, String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), "", "", localocg.a(), false);
      return;
      String str = "0X8007626";
      continue;
      label220:
      if (paramBoolean) {
        str = "0X8007625";
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_AndroidAppActivity);
    oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new quf(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo))) {
      QLog.d("ReadinjoySocialMsgCard", 2, "210 msgInfo is null ! " + paramKandianMsgBoxRedPntInfo);
    }
    TemplateBean localTemplateBean;
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mIconUrl)) {
          localJSONObject.put("msgbox_redpoint_icon", paramKandianMsgBoxRedPntInfo.mIconUrl);
        }
        localObject2 = paramKandianMsgBoxRedPntInfo.mCardSummary;
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131628743);
        }
        localJSONObject.put("msgbox_redpoint_content", new axkd(awbk.b((String)localObject1), 7, 17));
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mArticlePicUrl)) {
          localJSONObject.put("msgbox_redpoint_image", paramKandianMsgBoxRedPntInfo.mArticlePicUrl);
        }
        localJSONObject.put("msgbox_redpoint_count", String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131628744), new Object[] { bgmq.b(paramKandianMsgBoxRedPntInfo.mMsgCnt) }));
        localJSONObject.put("style_ID", "ReadInjoy_msgbox_cell");
        localJSONObject.put("message_type", paramKandianMsgBoxRedPntInfo.messageType);
        localJSONObject.put("feedsid", paramKandianMsgBoxRedPntInfo.feedsID);
        localJSONObject.put("feedstype", paramKandianMsgBoxRedPntInfo.feedsType);
        localJSONObject.put("sys_msg_from", paramKandianMsgBoxRedPntInfo.sysMsgFrom);
        localJSONObject.put("sys_msg_id", paramKandianMsgBoxRedPntInfo.sysMsgID);
        localJSONObject.put("reddot_num", paramKandianMsgBoxRedPntInfo.mMsgCnt);
        try
        {
          if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mExtraData))
          {
            localObject1 = new JSONObject(paramKandianMsgBoxRedPntInfo.mExtraData);
            localObject2 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              localJSONObject.put(str, ((JSONObject)localObject1).get(str));
            }
          }
          if (localTemplateBean == null) {
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          localTemplateBean = ProteusParser.getTemplateBean(rdg.a("default_feeds", true), localJSONObject);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
          break label439;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null)
        {
          QLog.d("ReadinjoySocialMsgCard", 1, "create proteus view error!");
          return;
        }
      }
      catch (JSONException paramKandianMsgBoxRedPntInfo)
      {
        paramKandianMsgBoxRedPntInfo.printStackTrace();
        return;
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    localObject2 = new RelativeLayout.LayoutParams(((Layout.Params)localObject2).mLayoutWidth, ((Layout.Params)localObject2).mLayoutHeight);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, (ViewGroup.LayoutParams)localObject2);
    label439:
    oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), localTemplateBean.getViewBean());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
    QLog.d("ReadinjoySocialMsgCard", 1, "set msg info : " + paramKandianMsgBoxRedPntInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     que
 * JD-Core Version:    0.7.0.1
 */