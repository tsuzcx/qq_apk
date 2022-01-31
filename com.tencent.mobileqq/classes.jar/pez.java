import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentWhiteSpace;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class pez
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  azwg jdField_a_of_type_Azwg;
  ComponentAccountSummary jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary;
  ComponentComment jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment;
  ComponentContentUgcOriginalHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader;
  ComponentContentUgcSource jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource;
  ComponentDivider jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider;
  ComponentHeaderFriendRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend;
  ComponentHeaderNewSocial jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial;
  ComponentHeaderPolymeric jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric;
  ComponentHeaderPublish jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish;
  ComponentHeaderRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend;
  ComponentHeaderSpecialTopic jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic;
  ComponentHeaderTopicRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend;
  ComponentHeaderUgc jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc;
  ComponentInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo;
  ComponentJump jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump;
  ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  ComponentSocialOperation jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation;
  ComponentTitle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle;
  ComponentTopicItemSingle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle;
  ComponentWhiteSpace jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace;
  Object jdField_a_of_type_JavaLangObject;
  List<ComponentTopicItemMulti> jdField_a_of_type_JavaUtilList;
  pey jdField_a_of_type_Pey;
  pfh jdField_a_of_type_Pfh;
  public qoe a;
  boolean jdField_a_of_type_Boolean = false;
  
  public pez(Context paramContext, azwg paramazwg, qoe paramqoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "FeedItemCell created, class = " + getClass().getSimpleName());
    }
    a(paramContext);
    a(paramazwg);
    a(paramqoe);
    a();
  }
  
  private void a(opw paramopw, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.jdField_a_of_type_Qoe.a();
    int j = localListView.getChildCount();
    this.jdField_a_of_type_Qoe.n();
    localArrayList1.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(paramopw);
    int i = 0;
    while (i < j)
    {
      opw localopw = (opw)localListView.getChildAt(i).getTag(2131313373);
      View localView = localListView.getChildAt(i);
      if ((localopw != null) && (localView != null) && (localopw != paramopw) && (paramopw.a().mGroupId == localopw.a().mGroupId) && (paramopw.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localopw);
      }
      i += 1;
    }
    paramopw = new pfg(this, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131303150);
      if (paramArrayList == null)
      {
        paramInt += 1;
      }
      else
      {
        if (paramInt != 0) {
          paramArrayList.setAnimationListener(null);
        }
        for (;;)
        {
          ((View)localArrayList1.get(paramInt)).startAnimation(paramArrayList);
          break;
          paramArrayList.setAnimationListener(paramopw);
        }
      }
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new Exception("FeedItemCell convertView is null!");
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public pey a()
  {
    return this.jdField_a_of_type_Pey;
  }
  
  public abstract pez a();
  
  public pez a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public pez a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public pez a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public pez a(azwg paramazwg)
  {
    this.jdField_a_of_type_Azwg = paramazwg;
    return this;
  }
  
  public pez a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public pez a(qoe paramqoe)
  {
    this.jdField_a_of_type_Qoe = paramqoe;
    return this;
  }
  
  public pez a(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pfh = new pfa(this);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.a(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(paramLong, paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = null;
    boolean bool = ((opw)this.jdField_a_of_type_JavaLangObject).a() instanceof AdvertisementInfo;
    if (obz.a(((opw)this.jdField_a_of_type_JavaLangObject).a())) {}
    for (;;)
    {
      beki localbeki = this.jdField_a_of_type_Qoe.a();
      beko localbeko = this.jdField_a_of_type_Qoe.a();
      if (bool)
      {
        if ((localbeki != null) && (localbeki.isShowing())) {
          localbeki.dismiss();
        }
        localbeko.b((oqh)this.jdField_a_of_type_JavaLangObject, ((AdvertisementInfo)((opw)this.jdField_a_of_type_JavaLangObject).a()).mAdDislikeInfos);
        localbeko.a(paramView, new pfb(this));
        localbeko.a(new pfc(this));
        localbeko.setOnDismissListener(new pfd(this, localbeko));
        label148:
        paramView = this.jdField_a_of_type_Qoe.a();
        if ((paramView != null) && (paramView.a()))
        {
          paramView.a();
          this.jdField_a_of_type_Qoe.b = true;
        }
      }
      try
      {
        paramView = new JSONObject();
        paramView.put("time", System.currentTimeMillis() / 1000L);
        paramView.put("channel_id", ((oqh)this.jdField_a_of_type_JavaLangObject).e());
        localObject = ((opw)this.jdField_a_of_type_JavaLangObject).a();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          paramView.put("folder_status", obz.d);
          paramView.put("kandian_mode", obz.e());
          paramView.put("feeds_type", "" + obz.a((BaseArticleInfo)localObject));
          paramView.put("rowkey", rvf.a((BaseArticleInfo)localObject));
          ndn.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
        }
        while (!(this.jdField_a_of_type_AndroidContentContext instanceof PluginBaseActivity))
        {
          return;
          localObject = ((opw)this.jdField_a_of_type_JavaLangObject).a().mDislikeInfos;
          break;
          if (rvf.a(this.jdField_a_of_type_Qoe.a()))
          {
            this.jdField_a_of_type_Qoe.a().a(paramView, ((opw)this.jdField_a_of_type_JavaLangObject).a(), ((oqh)this.jdField_a_of_type_JavaLangObject).b, this.jdField_a_of_type_AndroidViewView);
            break label148;
          }
          if ((localbeko != null) && (localbeko.isShowing())) {
            localbeko.dismiss();
          }
          localbeki.a((oqh)this.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
          localbeki.a(paramView, new pfe(this));
          localbeki.setOnDismissListener(new pff(this, localbeki));
          break label148;
        }
        paramView.put("folder_status", 1);
        awqx.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void a(View paramView, Map<String, Object> paramMap) {}
  
  pez b()
  {
    return g().h().i().k().l().n();
  }
  
  public pez b(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public void b() {}
  
  pez c()
  {
    return g().l().n();
  }
  
  public pez c(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish = new ComponentHeaderPublish(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public abstract pez d();
  
  public pez d(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc = new ComponentHeaderUgc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public abstract pez e();
  
  public pez e(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend = new ComponentHeaderRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public pez f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary = new ComponentAccountSummary(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez f(qoe paramqoe, azwg paramazwg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.setLogic(paramqoe, paramazwg);
    return this;
  }
  
  public pez g()
  {
    return this;
  }
  
  public pez h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle = new ComponentTitle(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pez i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo = new ComponentInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pez j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource = new ComponentContentUgcSource(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump = new ComponentJump(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider = new ComponentDivider(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pez m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace = new ComponentWhiteSpace(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pez n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      if ((this.jdField_a_of_type_JavaLangObject instanceof opw))
      {
        opw localopw = (opw)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setReadedStatus(this.jdField_a_of_type_Qoe.a(localopw.e(), localopw.a().mArticleID));
      }
      label119:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_Pey != null) {
        this.jdField_a_of_type_Pey.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_JavaLangObject);
      }
      try
      {
        e();
        return this;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return this;
      }
    }
    catch (Exception localException2)
    {
      break label119;
    }
  }
  
  public pez p()
  {
    if (this.jdField_a_of_type_Pfh == null) {}
    do
    {
      return this;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_Pey != null) {
        this.jdField_a_of_type_Pey.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_Pfh);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_Pfh);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_Pfh);
    return this;
  }
  
  public pez q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation = new ComponentSocialOperation(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader = new ComponentContentUgcOriginalHeader(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle = new ComponentTopicItemSingle(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez t()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    return this;
  }
  
  public pez u()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pez
 * JD-Core Version:    0.7.0.1
 */