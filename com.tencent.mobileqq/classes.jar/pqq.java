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

public abstract class pqq
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  baxy jdField_a_of_type_Baxy;
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
  pqp jdField_a_of_type_Pqp;
  pqy jdField_a_of_type_Pqy;
  public ram a;
  boolean jdField_a_of_type_Boolean = false;
  
  public pqq(Context paramContext, baxy parambaxy, ram paramram)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "FeedItemCell created, class = " + getClass().getSimpleName());
    }
    a(paramContext);
    a(parambaxy);
    a(paramram);
    a();
  }
  
  private void a(pau parampau, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.jdField_a_of_type_Ram.a();
    int j = localListView.getChildCount();
    this.jdField_a_of_type_Ram.n();
    localArrayList1.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(parampau);
    int i = 0;
    while (i < j)
    {
      pau localpau = (pau)localListView.getChildAt(i).getTag(2131379213);
      View localView = localListView.getChildAt(i);
      if ((localpau != null) && (localView != null) && (localpau != parampau) && (parampau.a().mGroupId == localpau.a().mGroupId) && (parampau.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localpau);
      }
      i += 1;
    }
    parampau = new pqx(this, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131368790);
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
          paramArrayList.setAnimationListener(parampau);
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
  
  public pqp a()
  {
    return this.jdField_a_of_type_Pqp;
  }
  
  public abstract pqq a();
  
  public pqq a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public pqq a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public pqq a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public pqq a(baxy parambaxy)
  {
    this.jdField_a_of_type_Baxy = parambaxy;
    return this;
  }
  
  public pqq a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public pqq a(ram paramram)
  {
    this.jdField_a_of_type_Ram = paramram;
    return this;
  }
  
  public pqq a(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setLogic(paramram, parambaxy);
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pqy = new pqr(this);
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
    boolean bool = ((pau)this.jdField_a_of_type_JavaLangObject).a() instanceof AdvertisementInfo;
    if (onh.a(((pau)this.jdField_a_of_type_JavaLangObject).a())) {}
    for (;;)
    {
      bfst localbfst = this.jdField_a_of_type_Ram.a();
      bfsz localbfsz = this.jdField_a_of_type_Ram.a();
      if (bool)
      {
        if ((localbfst != null) && (localbfst.isShowing())) {
          localbfst.dismiss();
        }
        localbfsz.b((pbf)this.jdField_a_of_type_JavaLangObject, ((AdvertisementInfo)((pau)this.jdField_a_of_type_JavaLangObject).a()).mAdDislikeInfos);
        localbfsz.a(paramView, new pqs(this));
        localbfsz.a(new pqt(this));
        localbfsz.setOnDismissListener(new pqu(this, localbfsz));
        label148:
        paramView = this.jdField_a_of_type_Ram.a();
        if ((paramView != null) && (paramView.b()))
        {
          paramView.a();
          this.jdField_a_of_type_Ram.b = true;
        }
      }
      try
      {
        paramView = new JSONObject();
        paramView.put("time", System.currentTimeMillis() / 1000L);
        paramView.put("channel_id", ((pbf)this.jdField_a_of_type_JavaLangObject).e());
        localObject = ((pau)this.jdField_a_of_type_JavaLangObject).a();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          paramView.put("folder_status", onh.d);
          paramView.put("kandian_mode", onh.e());
          paramView.put("feeds_type", "" + onh.a((BaseArticleInfo)localObject));
          paramView.put("rowkey", shu.a((BaseArticleInfo)localObject));
          nol.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
        }
        while (!(this.jdField_a_of_type_AndroidContentContext instanceof PluginBaseActivity))
        {
          return;
          localObject = ((pau)this.jdField_a_of_type_JavaLangObject).a().mDislikeInfos;
          break;
          if (shu.a(this.jdField_a_of_type_Ram.a()))
          {
            this.jdField_a_of_type_Ram.a().a(paramView, ((pau)this.jdField_a_of_type_JavaLangObject).a(), ((pbf)this.jdField_a_of_type_JavaLangObject).b, this.jdField_a_of_type_AndroidViewView);
            break label148;
          }
          if ((localbfsz != null) && (localbfsz.isShowing())) {
            localbfsz.dismiss();
          }
          localbfst.a((pbf)this.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
          localbfst.a(paramView, new pqv(this));
          localbfst.setOnDismissListener(new pqw(this, localbfst));
          break label148;
        }
        paramView.put("folder_status", 1);
        axqy.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void a(View paramView, Map<String, Object> paramMap) {}
  
  pqq b()
  {
    return g().h().i().k().l().n();
  }
  
  public pqq b(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.setLogic(paramram, parambaxy);
    return this;
  }
  
  public void b() {}
  
  pqq c()
  {
    return g().l().n();
  }
  
  public pqq c(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish = new ComponentHeaderPublish(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.setLogic(paramram, parambaxy);
    return this;
  }
  
  public abstract pqq d();
  
  public pqq d(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc = new ComponentHeaderUgc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.setLogic(paramram, parambaxy);
    return this;
  }
  
  public abstract pqq e();
  
  public pqq e(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend = new ComponentHeaderRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend.setLogic(paramram, parambaxy);
    return this;
  }
  
  public pqq f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary = new ComponentAccountSummary(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq f(ram paramram, baxy parambaxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.setLogic(paramram, parambaxy);
    return this;
  }
  
  public pqq g()
  {
    return this;
  }
  
  public pqq h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle = new ComponentTitle(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pqq i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo = new ComponentInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pqq j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource = new ComponentContentUgcSource(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump = new ComponentJump(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider = new ComponentDivider(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pqq m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace = new ComponentWhiteSpace(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public pqq n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq o()
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
      if ((this.jdField_a_of_type_JavaLangObject instanceof pau))
      {
        pau localpau = (pau)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setReadedStatus(this.jdField_a_of_type_Ram.a(localpau.e(), localpau.a().mArticleID));
      }
      label119:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
      }
      if (this.jdField_a_of_type_Pqp != null) {
        this.jdField_a_of_type_Pqp.a(this.jdField_a_of_type_JavaLangObject);
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
  
  public pqq p()
  {
    if (this.jdField_a_of_type_Pqy == null) {}
    do
    {
      return this;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_Pqp != null) {
        this.jdField_a_of_type_Pqp.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_Pqy);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_Pqy);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_Pqy);
    return this;
  }
  
  public pqq q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation = new ComponentSocialOperation(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader = new ComponentContentUgcOriginalHeader(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle = new ComponentTopicItemSingle(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq t()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    return this;
  }
  
  public pqq u()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqq
 * JD-Core Version:    0.7.0.1
 */