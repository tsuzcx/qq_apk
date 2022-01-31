import NS_KING_SOCIALIZE_META.stMetaGeoInfo;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class tfk
  extends tgd<stFeed>
  implements View.OnClickListener
{
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "profile", "nickname", "content", "video", "more_operations" });
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ArrayList<stSimpleComment> jdField_a_of_type_JavaUtilArrayList;
  private tbb jdField_a_of_type_Tbb;
  private tep jdField_a_of_type_Tep;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  
  private tfk(ViewGroup paramViewGroup, tbb paramtbb)
  {
    super(paramViewGroup, 2131560221);
    this.jdField_a_of_type_Tbb = paramtbb;
    e();
    f();
  }
  
  private int a()
  {
    return tel.a().a.get(getLayoutPosition()) + 1;
  }
  
  public static tfk a(ViewGroup paramViewGroup, tbb paramtbb)
  {
    return new tfk(paramViewGroup, paramtbb);
  }
  
  private void a(stMagicBrand paramstMagicBrand, stMetaGeoInfo paramstMetaGeoInfo, int paramInt)
  {
    String str1 = "";
    boolean bool1;
    if (paramstMagicBrand != null)
    {
      str1 = paramstMagicBrand.text;
      if (paramstMagicBrand.type == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      String str2 = str1;
      if (!bool1)
      {
        bool2 = bool1;
        str2 = str1;
        if (paramstMetaGeoInfo != null)
        {
          str2 = paramstMetaGeoInfo.name;
          bool2 = false;
        }
      }
      if (!TextUtils.isEmpty(str2))
      {
        this.i.setText(str2);
        this.i.setSelected(bool2);
        paramstMetaGeoInfo = this.i;
        if (paramstMagicBrand != null)
        {
          paramstMagicBrand = paramstMagicBrand.schema;
          label99:
          paramstMetaGeoInfo.setTag(paramstMagicBrand);
          tlf.a(0, new View[] { this.i });
        }
      }
      for (;;)
      {
        a();
        return;
        bool1 = false;
        break;
        paramstMagicBrand = "";
        break label99;
        tlf.a(8, new View[] { this.i });
      }
      bool1 = false;
    }
  }
  
  private void a(stSimpleComment paramstSimpleComment, TextView paramTextView)
  {
    boolean bool;
    label89:
    int i1;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      tlo.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramTextView);
      if (bool) {
        break label257;
      }
      tlo.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      tlo.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramTextView = this.jdField_a_of_type_Tbb.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      paramTextView.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, paramstSimpleComment);
      paramstSimpleComment = tlf.a("weishi://profile?person_id=" + paramstSimpleComment.posterId, 701);
      i1 = 1000002;
      if (!xoo.a(a())) {
        break label308;
      }
      i1 = 1000003;
    }
    for (;;)
    {
      paramTextView.a = true;
      tlo.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
      paramstSimpleComment = this.jdField_a_of_type_UserGrowthStFeed.feed;
      WSPublicAccReport.getInstance().reportCommentDing(paramTextView.a(), a(), i1, paramstSimpleComment);
      return;
      bool = false;
      break;
      label257:
      if (paramstSimpleComment.dingNum > 1L)
      {
        tlo.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
        break label89;
      }
      paramstSimpleComment.dingNum -= 1L;
      tlo.c("comment", "执行取消点赞 ...............");
      break label89;
      label308:
      tfa.a(this.jdField_a_of_type_Tbb.a(), paramstSimpleComment);
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i2 = 8;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    tlv.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(tlf.a(paramstSimpleMetaPerson.nick));
    this.d.setText(tlf.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    boolean bool = tlf.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      tlf.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      localTextView = this.f;
      if (!tlf.a(paramstSimpleMetaPerson.followStatus)) {
        break label171;
      }
    }
    label171:
    for (int i1 = i2;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.g.setVisibility(4);
      this.e.setVisibility(this.f.getVisibility());
      return;
      i1 = 8;
      break;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        tgg.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.l, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new tfo(this));
    if (TextUtils.isEmpty(paramString))
    {
      tlf.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    tlf.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      tjt.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (tlf.a(paramArrayList))
    {
      tlf.a(8, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.m, this.n, this.o });
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(tlf.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView localTextView = this.m;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label298;
        }
        bool = true;
        localTextView.setSelected(bool);
        tlf.a(0, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.m });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(tlf.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.n;
        if (paramArrayList.isDing != 1) {
          break label303;
        }
        bool = true;
        label227:
        ((TextView)localObject).setSelected(bool);
        tlf.a(0, new View[] { this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.n });
      }
    }
    for (;;)
    {
      paramArrayList = tlf.a(2131693790, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
      this.o.setText(paramArrayList);
      this.o.setVisibility(0);
      return;
      label298:
      bool = false;
      break;
      label303:
      bool = false;
      break label227;
      tlf.a(8, new View[] { this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.n });
    }
  }
  
  private void b(int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    tdn localtdn;
    if ((this.jdField_a_of_type_Tbb != null) && (this.jdField_a_of_type_Tbb.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localtdn = this.jdField_a_of_type_Tbb.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localtdn == null) {
        tlo.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    tlo.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    localtdn.a(getPosition());
    localtdn.a(localstSimpleMetaFeed);
    localtdn.a("focus");
    localtdn.a();
    tff.a().a(new WSCommentShowEvent(true));
    if (paramInt == -1)
    {
      WSPublicAccReport.getInstance().reportCommentEntryClick(localtdn.a(), WSPublicAccReport.getEntryPositionId(localtdn.a()) + a(), 1000001, localstSimpleMetaFeed);
      return;
    }
    if (paramInt == 0)
    {
      WSPublicAccReport.getInstance().reportCommentEntryClick(localtdn.a(), WSPublicAccReport.getEntryPositionId(localtdn.a()) + a(), 1000001, localstSimpleMetaFeed);
      return;
    }
    WSPublicAccReport.getInstance().reportCommentEntryTextClick(localtdn.a(), a(), 1000001, localstSimpleMetaFeed);
  }
  
  private void b(String paramString)
  {
    if (xoo.a(a()))
    {
      a(paramString, tjw.c);
      return;
    }
    a(paramString, tjw.b);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("video", tjw.i);
      return;
    }
    c("video");
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  private void c(String paramString)
  {
    a(paramString, tjw.a);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", tjw.t);
      return;
    }
    a("pausebutton", tjw.s);
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null)) {
      return false;
    }
    return tlf.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)b(2131368479));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)b(2131368492));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)b(2131368495));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)b(2131368496));
    this.d = ((TextView)b(2131368502));
    this.e = ((TextView)b(2131368488));
    this.f = ((TextView)b(2131368491));
    this.g = ((TextView)b(2131368490));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)b(2131368489));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)b(2131368503));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)b(2131368487));
    this.h = ((TextView)b(2131368498));
    this.i = ((TextView)b(2131368500));
    this.j = ((TextView)b(2131368499));
    this.k = ((TextView)b(2131368480));
    this.l = ((TextView)b(2131368493));
    this.p = ((TextView)b(2131368494));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)b(2131368484));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)b(2131368485));
    this.m = ((TextView)b(2131368482));
    this.n = ((TextView)b(2131368483));
    this.o = ((TextView)b(2131368486));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void f()
  {
    tlf.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new tfl(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new tfm(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new tfn(this));
  }
  
  private void g()
  {
    WSFollowFragment.b = true;
    if (this.jdField_a_of_type_Tbb.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null)
    {
      tlo.c("comment", "need create presenter ,holder hashCode:" + hashCode());
      return;
    }
    tlo.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
    if (!a()) {
      this.jdField_a_of_type_Tbb.a().d();
    }
    WSVerticalPageFragment.a(this.jdField_a_of_type_Tbb.a(), "follow_tab", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    a(false);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = tlf.a(tlu.e(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165690));
  }
  
  private void i()
  {
    if (!ndk.a(a()))
    {
      bfhq.a().a(2131721476);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      tlo.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_Tep == null) {
      this.jdField_a_of_type_Tep = tep.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (tlf.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", tjw.r);
      tlf.a(a(), new tfp(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", tjw.q);
    this.jdField_a_of_type_Tep.b(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void j()
  {
    tgg.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.l, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    l();
  }
  
  private void k()
  {
    this.jdField_a_of_type_Tbb.a().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Tbb.notifyItemRemoved(getAdapterPosition());
    bfhq.a().a(2131721468);
  }
  
  private void l()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", tjw.g);
      return;
      i1 = 0;
    }
    a("video", tjw.h);
  }
  
  public stFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStFeed;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    this.l.setVisibility(0);
    this.p.setVisibility(8);
    this.l.setSelected(b());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(stFeed paramstFeed)
  {
    super.a(paramstFeed);
    if ((paramstFeed == null) || (paramstFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
    a(paramstFeed.feed.poster);
    a(paramstFeed.feed.feed_desc);
    h();
    a(paramstFeed.feed.magicBrand, paramstFeed.feed.geoInfo, paramstFeed.feed.is_ding);
    a(paramstFeed.feed.simpleComments);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      tlo.d("comment", "添加评论后匹配正确,添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    paramstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
    paramstSimpleMetaFeed.total_comment_num += 1;
    paramstSimpleMetaFeed = tlf.a(2131693790, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    tlo.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.o.setText(paramstSimpleMetaFeed);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h == null) {
      return;
    }
    this.h.setSelected(paramBoolean);
  }
  
  public void a(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setSelected(true);
      return;
    }
    paramTextView.setSelected(false);
  }
  
  public void b()
  {
    if (c())
    {
      this.f.setVisibility(8);
      this.g.setVisibility(0);
    }
    for (;;)
    {
      this.e.setVisibility(0);
      return;
      this.f.setVisibility(0);
      this.g.setVisibility(4);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        tgg.a().a(localstSimpleMetaFeed.id);
      }
    }
  }
  
  public void d()
  {
    Object localObject = new ArrayList(jdField_a_of_type_JavaUtilList);
    if (this.e.getVisibility() == 0)
    {
      ((List)localObject).add("follow");
      ((List)localObject).add("close");
    }
    if (this.i.getVisibility() == 0) {
      ((List)localObject).add("bottom_label");
    }
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i1 = a();
      if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
      for (localObject = this.jdField_a_of_type_UserGrowthStFeed.feed;; localObject = null)
      {
        tjt.a(str, i1, (stSimpleMetaFeed)localObject);
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    tlo.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
    if ((a() != null) && (a().feed != null) && (a().feed.poster != null)) {}
    for (String str = a().feed.poster.id;; str = "")
    {
      switch (paramView.getId())
      {
      case 2131368481: 
      case 2131368487: 
      case 2131368489: 
      case 2131368497: 
      default: 
      case 2131368479: 
      case 2131368492: 
      case 2131368495: 
      case 2131368496: 
      case 2131368490: 
      case 2131368491: 
      case 2131368488: 
      case 2131368498: 
      case 2131368500: 
      case 2131368499: 
      case 2131368480: 
      case 2131368493: 
      case 2131368494: 
      case 2131368484: 
      case 2131368485: 
      case 2131368482: 
      case 2131368483: 
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                tlf.a(this.jdField_a_of_type_Tbb.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str);
                c("profile");
                return;
                paramView = str;
                if (a() != null)
                {
                  paramView = str;
                  if (a().feed != null)
                  {
                    paramView = str;
                    if (a().feed.poster != null) {
                      paramView = a().feed.poster.id;
                    }
                  }
                }
                tlf.a(this.jdField_a_of_type_Tbb.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, paramView);
                c("nickname");
                return;
                i();
                return;
                k();
                c("close");
                return;
                paramView = this.jdField_a_of_type_Tbb.a();
                if (this.jdField_a_of_type_Tbb.jdField_a_of_type_Tgd == this) {
                  if (paramView.c()) {
                    paramView.b();
                  }
                }
                for (;;)
                {
                  c(a());
                  return;
                  paramView.c();
                  continue;
                  this.jdField_a_of_type_Tbb.a(this);
                }
              } while (!(paramView.getTag() instanceof stSchema));
              tlf.a(this.jdField_a_of_type_Tbb.a(), (stSchema)paramView.getTag(), 700, a(), "bottom_label");
              b("bottom_label");
              return;
            } while (this.jdField_a_of_type_UserGrowthStFeed == null);
            tlr.a(a(), this.jdField_a_of_type_UserGrowthStFeed.feed, 20, a(), "focus");
            c("more_operations");
            return;
            b(-1);
            return;
            j();
            return;
            b(1);
            return;
            b(2);
            return;
          } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
          a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.m);
          return;
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1));
        a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.n);
        return;
      }
      b(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfk
 * JD-Core Version:    0.7.0.1
 */