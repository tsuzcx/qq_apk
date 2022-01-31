import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;

public class snf
  extends soc
  implements IEventReceiver, urc
{
  public int a;
  public Activity a;
  protected Rect a;
  public View a;
  public ImageView a;
  public TextView a;
  public ShareGroupItem a;
  public CommentLikeFeedItem a;
  private TagFlowLayout jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout;
  public InnerListView a;
  public smv a;
  private snk jdField_a_of_type_Snk;
  protected sps a;
  private tci jdField_a_of_type_Tci;
  public uin a;
  public uio a;
  private uqy jdField_a_of_type_Uqy;
  protected boolean a;
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public snf(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, uio paramuio, int paramInt)
  {
    super(paramContext, 2131495651);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Uio = paramuio;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramuio.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Sps = ((sps)sqg.a(15));
    paramContext = new smz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Uio.a());
    paramActivity = snr.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_Uio.b());
    paramActivity.b(this.jdField_a_of_type_Uio.c());
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static snf a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, uio paramuio, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new snf(paramContext, paramActivity, paramViewGroup, paramuio, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void Q_()
  {
    tgp.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      urp.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        urk.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public sod a()
  {
    return null;
  }
  
  public soe a()
  {
    return new sng(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Tci != null) {
      this.jdField_a_of_type_Tci.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304703));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304701));
    this.d = ((ImageView)paramView.findViewById(2131304704));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298912));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131298940));
    this.c = ((ImageView)paramView.findViewById(2131307553));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131307550));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299651);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131311056));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Soe);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Soe);
    this.d.setOnClickListener(this.jdField_a_of_type_Soe);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Soe);
    this.c.setOnClickListener(this.jdField_a_of_type_Soe);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Soe);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Soe);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131100760), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131100760));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845380);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845373);
      this.d.setImageResource(2130845376);
      this.c.setImageResource(2130845426);
    }
    this.jdField_a_of_type_Uqy = new uqy(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Uqy);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    smz localsmz = (smz)a("commentLego");
    localsmz.a(new snu(localsmz, paramShareGroupItem));
  }
  
  public void a(List paramList)
  {
    int j = 1;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
    {
      bool1 = true;
      b(bool1);
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      bool2 = paramList.isVipButNoFriend();
      bool1 = paramList.isSubscribeButNoFriend();
      if ((!bool2) && (!paramList.isMe()) && (!bool1)) {
        break label563;
      }
      i = 1;
      label67:
      if ((i == 0) && ((this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()))) {
        break label568;
      }
      this.d.setVisibility(0);
      label96:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_Uin == null))) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638620) + vms.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label178:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label592;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838504));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label237:
      if (!(this.jdField_a_of_type_Uio instanceof ujm)) {
        break label610;
      }
      paramList = "";
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1) {
        break label645;
      }
      paramList = vmz.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
      if ((!TextUtils.isEmpty(paramList)) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType != 1)) {
        break label639;
      }
      paramList = "来自微视APP";
      bool1 = true;
    }
    for (;;)
    {
      String str = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mQimSyncWording;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(0);
      this.jdField_a_of_type_Uqy.a(((ujm)this.jdField_a_of_type_Uio).d, str, ((ujm)this.jdField_a_of_type_Uio).c, bool1, paramList);
      this.jdField_a_of_type_Uqy.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10)
        {
          paramList = "1";
          label374:
          urp.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_Uio.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_Uio.a().feedId });
        }
      }
      else
      {
        label430:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_Uio.b().size())) {
          break label622;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638646) + vms.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + ajjy.a(2131638624));
        label519:
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label634;
        }
      }
      label563:
      label568:
      label580:
      label592:
      label610:
      label622:
      label634:
      for (i = j;; i = 0)
      {
        if (i != 0) {
          ((sqo)sqg.a(23)).c();
        }
        d();
        return;
        bool1 = false;
        break;
        i = 0;
        break label67;
        this.d.setVisibility(8);
        break label96;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label178;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label237;
        paramList = "3";
        break label374;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(8);
        break label430;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label519;
      }
      label639:
      bool1 = true;
      continue;
      label645:
      bool1 = false;
    }
  }
  
  public void a(smv paramsmv)
  {
    ((smz)a("commentLego")).a(paramsmv);
    this.jdField_a_of_type_Smv = paramsmv;
  }
  
  public void a(snk paramsnk)
  {
    this.jdField_a_of_type_Snk = paramsnk;
    ((smz)a("commentLego")).a(paramsnk);
  }
  
  public void a(uin paramuin)
  {
    this.jdField_a_of_type_Uin = paramuin;
  }
  
  public void a(uio paramuio, ShareGroupItem paramShareGroupItem, uin paramuin)
  {
    this.jdField_a_of_type_Uio = paramuio;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramuio.a();
    smz localsmz = (smz)a("commentLego");
    snr localsnr = (snr)a("likeLego");
    j();
    i();
    if (paramuin != null) {
      a(paramuin);
    }
    for (;;)
    {
      localsmz.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramuio.a());
      localsnr.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localsmz.c(this.jdField_a_of_type_Uio.b());
      localsnr.c(this.jdField_a_of_type_Uio.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(vil paramvil)
  {
    tgp.a(this.jdField_a_of_type_AndroidAppActivity, paramvil);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramvil.jdField_a_of_type_Int != 0) {
        break label108;
      }
    }
    label108:
    for (String str2 = "1";; str2 = "2")
    {
      urp.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramvil.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      urk.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
      str1 = "-1";
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845374);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845380);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845379);
  }
  
  public void c()
  {
    smz localsmz = (smz)a("commentLego");
    snr localsnr = (snr)a("likeLego");
    localsmz.c(this.jdField_a_of_type_Uio.b());
    localsnr.c(this.jdField_a_of_type_Uio.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Uio.b().size();
    int j;
    int i;
    if ((this.jdField_a_of_type_Uio.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = skt.a(2131361824);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = skt.a(2131361821);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = skt.a(2131361823);
      } else if ((k > 0) && (j == 0)) {
        i = skt.a(2131361822);
      } else {
        i = skt.a(2131361819);
      }
    }
    label172:
    float f = skt.a(2131361820);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, vms.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638644), 0).a();
      return;
    }
    boolean bool;
    label42:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      snm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((snr)a("likeLego")).a(bool);
      b(bool);
      smz.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = urp.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label211;
      }
    }
    label211:
    for (Object localObject = ((srk)localObject).getUnionId();; localObject = "")
    {
      urp.a("home_page", "clk_like", urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), urp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FeedCommentLikeLego", 2, "onLikeBtnClick: isLike:" + bool);
      return;
      bool = false;
      break label42;
    }
  }
  
  public void f()
  {
    ujm localujm;
    if ((this.jdField_a_of_type_Uio instanceof ujm))
    {
      localujm = (ujm)this.jdField_a_of_type_Uio;
      if (((ujm)this.jdField_a_of_type_Uio).c) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localujm.c = bool;
      urp.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void h()
  {
    Object localObject;
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type != 1) {
        break label193;
      }
      localObject = (GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      if (this.jdField_a_of_type_Int != 10) {
        break label149;
      }
      localObject = ((GeneralFeedItem)localObject).wsSchemaForMain;
      if (this.jdField_a_of_type_Int != 10) {
        break label273;
      }
      str = "1";
      label56:
      vpg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (!vnd.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label315;
      }
    }
    label149:
    label315:
    for (int i = 2;; i = 1)
    {
      urp.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        break;
      }
      urk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      localObject = "";
      break;
      label193:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type == 3)
      {
        localObject = (GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        if (this.jdField_a_of_type_Int == 10)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMain;
          break;
        }
        if (this.jdField_a_of_type_Int == 12)
        {
          localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMemories;
          break;
        }
        urk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      localObject = "";
      break;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break label56;
      }
      urk.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      str = "-1";
      break label56;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    smz localsmz = (smz)a("commentLego");
    localsmz.a(new smt(localsmz));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_Uin = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snf
 * JD-Core Version:    0.7.0.1
 */