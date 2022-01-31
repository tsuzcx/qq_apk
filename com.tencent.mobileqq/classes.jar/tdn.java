import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetFeedCommentListRsp;
import NS_KING_INTERFACE.stPostCommentReplyRsp;
import NS_KING_INTERFACE.stPostFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stMetaReply;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.1;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.6;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.7;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class tdn
  implements View.OnClickListener, Animation.AnimationListener, IEventReceiver
{
  public int a;
  private long jdField_a_of_type_Long;
  private stMetaComment jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment;
  private stMetaReply jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new tdo(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "comment";
  private ArrayList<stMetaComment> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Long, stMetaPerson> jdField_a_of_type_JavaUtilMap = new HashMap();
  private tcs jdField_a_of_type_Tcs;
  private tcu jdField_a_of_type_Tcu;
  private tdf jdField_a_of_type_Tdf;
  private tds jdField_a_of_type_Tds;
  private tdt jdField_a_of_type_Tdt;
  private tdu jdField_a_of_type_Tdu;
  private yav jdField_a_of_type_Yav;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Long, stMetaReply> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 140;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public tdn(Fragment paramFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramFragment.getActivity();
    this.jdField_a_of_type_AndroidContentContext = paramFragment.getActivity().getApplicationContext();
    this.jdField_a_of_type_Tcu = new tcu(this);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Tds == null)
    {
      this.jdField_a_of_type_Tds = new tds(this, paramInt);
      uht.a().registerSubscriber(this.jdField_a_of_type_Tds);
      tlo.d(this.jdField_a_of_type_JavaLangString, "注册一次评论监听器 , currentPage:" + paramInt);
      return;
    }
    tlo.d(this.jdField_a_of_type_JavaLangString, "复用评论监听器 , currentPage:" + paramInt);
  }
  
  private int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  private stMetaPerson a()
  {
    if (xxf.a() != null)
    {
      localObject1 = xxf.a();
      localObject2 = new stMetaPerson();
      ((stMetaPerson)localObject2).id = ((CertifiedAccountMeta.StUser)localObject1).id.get();
      ((stMetaPerson)localObject2).nick = ((CertifiedAccountMeta.StUser)localObject1).nick.get();
      ((stMetaPerson)localObject2).type = ((CertifiedAccountMeta.StUser)localObject1).type.get();
      return localObject2;
    }
    Object localObject1 = new stMetaPerson();
    ((stMetaPerson)localObject1).id = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {}
    for (((stMetaPerson)localObject1).nick = bdbt.h((QQAppInterface)localObject2, ((stMetaPerson)localObject1).id);; ((stMetaPerson)localObject1).nick = "")
    {
      ((stMetaPerson)localObject1).type = 0;
      return localObject1;
    }
  }
  
  private stSimpleMetaFeed a()
  {
    int i = a();
    return (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  @NotNull
  private WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = tee.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = tlv.a(1);
    localWSDownloadParams.mStReportItem = tjr.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 1000L)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694777), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString2, 0).a();
  }
  
  private void a(stMetaComment paramstMetaComment, stMetaReply paramstMetaReply, boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      tlo.d(this.jdField_a_of_type_JavaLangString, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Tdf == null) {
      this.jdField_a_of_type_Tdf = new tdf(this.jdField_a_of_type_AndroidAppActivity);
    }
    String str2;
    String str1;
    if (paramstMetaReply != null) {
      if (paramstMetaReply.poster != null)
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692455), new Object[] { paramstMetaReply.poster.nick });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        if (a(paramstMetaReply.poster, a().poster)) {}
        this.jdField_a_of_type_Tdf.b(str1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Tdf.a(new tdq(this, paramstMetaComment, paramstMetaReply));
      g();
      this.jdField_a_of_type_Tdf.a(paramInt);
      return;
      if ((paramstMetaComment != null) && (paramstMetaComment.poster != null))
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692455), new Object[] { paramstMetaComment.poster.nick });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        if (a(paramstMetaComment.poster, a().poster)) {}
        this.jdField_a_of_type_Tdf.b(str1);
      }
      else
      {
        this.jdField_a_of_type_Tdf.b(this.jdField_a_of_type_AndroidContentContext.getString(2131692450));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370758);
      if (localTextView != null)
      {
        if (!paramBoolean) {
          break label37;
        }
        localTextView.setText(2131693932);
      }
    }
    return;
    label37:
    localTextView.setText("");
  }
  
  private boolean a()
  {
    return true;
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return false;
  }
  
  private boolean a(stMetaPerson paramstMetaPerson)
  {
    if ((paramstMetaPerson != null) && (xxf.a() != null) && (paramstMetaPerson.id.equals(xxf.a().id.get()))) {}
    while ((paramstMetaPerson != null) && (paramstMetaPerson.id.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      return true;
    }
    return false;
  }
  
  private boolean a(stMetaPerson paramstMetaPerson, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    return (paramstMetaPerson != null) && (paramstSimpleMetaPerson != null) && (paramstMetaPerson.id.equals(paramstSimpleMetaPerson.id));
  }
  
  private String b()
  {
    if (a() == null)
    {
      tlo.d(this.jdField_a_of_type_JavaLangString, 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private void b()
  {
    if (b() != null)
    {
      if (this.h) {
        tlo.d(this.jdField_a_of_type_JavaLangString, "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(a().a(b())))
    {
      tlo.d(this.jdField_a_of_type_JavaLangString, "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
      return;
    }
    this.h = true;
    tlo.d(this.jdField_a_of_type_JavaLangString, "请求开始 preLoading = true");
    a().a(a(), false);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      tlo.b(this.jdField_a_of_type_JavaLangString, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Tcs.b(a().poster.id);
      this.jdField_a_of_type_Tcs.a(a());
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 509	tdn:d	()V
    //   8: aload_0
    //   9: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   12: ifnull +101 -> 113
    //   15: aload_0
    //   16: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: invokevirtual 514	java/util/ArrayList:size	()I
    //   22: ifle +91 -> 113
    //   25: aload_0
    //   26: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   29: ifnull +25 -> 54
    //   32: aload_0
    //   33: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   36: aload_0
    //   37: getfield 454	tdn:jdField_a_of_type_Long	J
    //   40: invokestatic 519	yda:a	(J)Ljava/lang/String;
    //   43: invokevirtual 433	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   46: aload_0
    //   47: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   50: iconst_0
    //   51: invokevirtual 520	android/widget/TextView:setVisibility	(I)V
    //   54: aload_0
    //   55: getfield 488	tdn:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   58: ifnull +19 -> 77
    //   61: aload_0
    //   62: getfield 488	tdn:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   65: iconst_0
    //   66: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   69: aload_0
    //   70: getfield 522	tdn:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   73: iconst_0
    //   74: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   77: aload_0
    //   78: getfield 308	tdn:jdField_a_of_type_Tcs	Ltcs;
    //   81: invokevirtual 525	tcs:getCount	()I
    //   84: ifne +5 -> 89
    //   87: iconst_1
    //   88: istore_1
    //   89: aload_0
    //   90: iload_1
    //   91: invokespecial 527	tdn:a	(Z)V
    //   94: aload_0
    //   95: getfield 529	tdn:jdField_a_of_type_Tdt	Ltdt;
    //   98: ifnull +12 -> 110
    //   101: aload_0
    //   102: getfield 529	tdn:jdField_a_of_type_Tdt	Ltdt;
    //   105: invokeinterface 533 1 0
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload_0
    //   114: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   117: ifnull -63 -> 54
    //   120: aload_0
    //   121: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   124: ldc 64
    //   126: invokevirtual 433	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   129: aload_0
    //   130: getfield 458	tdn:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   133: bipush 8
    //   135: invokevirtual 520	android/widget/TextView:setVisibility	(I)V
    //   138: goto -84 -> 54
    //   141: astore_2
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	tdn
    //   1	90	1	bool	boolean
    //   141	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	54	141	finally
    //   54	77	141	finally
    //   77	87	141	finally
    //   89	110	141	finally
    //   113	138	141	finally
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = a().a(b());
    }
    this.jdField_a_of_type_Long += paramInt;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WsCommentPresenter.7(this));
    }
    uht.a().dispatch(new ybt(5, new Object[] { b(), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 110	tdn:jdField_a_of_type_Tcu	Ltcu;
    //   6: ifnonnull +16 -> 22
    //   9: aload_0
    //   10: getfield 57	tdn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: ldc_w 564
    //   16: invokestatic 151	tlo:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 470	tdn:a	()Ltcu;
    //   27: aload_0
    //   28: invokespecial 463	tdn:b	()Ljava/lang/String;
    //   31: invokevirtual 567	tcu:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokevirtual 470	tdn:a	()Ltcu;
    //   42: aload_0
    //   43: invokespecial 463	tdn:b	()Ljava/lang/String;
    //   46: invokevirtual 473	tcu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   49: putfield 70	tdn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 308	tdn:jdField_a_of_type_Tcs	Ltcs;
    //   63: ifnull +29 -> 92
    //   66: aload_0
    //   67: getfield 308	tdn:jdField_a_of_type_Tcs	Ltcs;
    //   70: invokevirtual 569	tcs:a	()V
    //   73: aload_0
    //   74: getfield 308	tdn:jdField_a_of_type_Tcs	Ltcs;
    //   77: aload_0
    //   78: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: invokevirtual 572	tcs:a	(Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 308	tdn:jdField_a_of_type_Tcs	Ltcs;
    //   89: invokevirtual 575	tcs:notifyDataSetChanged	()V
    //   92: aload_0
    //   93: getfield 57	tdn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: new 132	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 577
    //   106: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 76	tdn:jdField_d_of_type_Int	I
    //   113: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 579
    //   119: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokespecial 160	tdn:a	()I
    //   126: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 151	tlo:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 581	tdn:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   139: ifnull +30 -> 169
    //   142: aload_0
    //   143: getfield 76	tdn:jdField_d_of_type_Int	I
    //   146: aload_0
    //   147: invokespecial 160	tdn:a	()I
    //   150: if_icmpeq +19 -> 169
    //   153: aload_0
    //   154: aload_0
    //   155: invokespecial 160	tdn:a	()I
    //   158: putfield 76	tdn:jdField_d_of_type_Int	I
    //   161: aload_0
    //   162: getfield 581	tdn:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   165: iconst_0
    //   166: invokevirtual 586	android/widget/ListView:setSelection	(I)V
    //   169: aload_0
    //   170: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   173: ifnull -154 -> 19
    //   176: aload_0
    //   177: getfield 304	tdn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   180: invokevirtual 514	java/util/ArrayList:size	()I
    //   183: ifle -164 -> 19
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual 470	tdn:a	()Ltcu;
    //   191: aload_0
    //   192: invokespecial 463	tdn:b	()Ljava/lang/String;
    //   195: invokevirtual 536	tcu:a	(Ljava/lang/String;)I
    //   198: i2l
    //   199: putfield 454	tdn:jdField_a_of_type_Long	J
    //   202: goto -183 -> 19
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	tdn
    //   205	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	205	finally
    //   22	92	205	finally
    //   92	169	205	finally
    //   169	202	205	finally
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366083));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364539);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364577);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366084);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364570));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363606));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363587));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364550);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377631));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363574);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Tdu = new tdu(this);
    if (this.jdField_a_of_type_Tcs == null)
    {
      tlo.a("comment", "create mCommentAdapter ...");
      this.jdField_a_of_type_Tcs = new tcs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tdu);
    }
    for (;;)
    {
      this.jdField_a_of_type_Tcs.b(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Tcs.a(a());
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Tcs);
      this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new tdp(this));
      }
      return;
      tlo.a("comment", "复用 mCommentAdapter ...");
    }
  }
  
  private void f()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772019);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Tdt != null) {
        this.jdField_a_of_type_Tdt.e();
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Tdf == null)
    {
      tlo.d(this.jdField_a_of_type_JavaLangString, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Tdf.a(new tdr(this));
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {}
    for (int i = 1;; i = 0)
    {
      b(0);
      if (i != 0) {
        a();
      }
      if ((this.jdField_a_of_type_Tdf != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Tdf.a());
      }
      return;
    }
  }
  
  private void i()
  {
    if (this.h)
    {
      this.h = false;
      tlo.d(this.jdField_a_of_type_JavaLangString, "请求结束 preLoading = false");
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WsCommentPresenter.8(this));
    }
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public tcu a()
  {
    if (this.jdField_a_of_type_Tcu == null) {
      this.jdField_a_of_type_Tcu = new tcu(this);
    }
    return this.jdField_a_of_type_Tcu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      b(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_c_of_type_Int <= 3))
    {
      this.jdField_c_of_type_Int += 1;
      a().a().postDelayed(new WsCommentPresenter.1(this), this.jdField_c_of_type_Int * 500);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    String str;
    do
    {
      return;
      localstSimpleMetaFeed = a();
      if (localstSimpleMetaFeed == null)
      {
        tlo.d(this.jdField_a_of_type_JavaLangString, "showCommentListWithAnim, but feed is null");
        return;
      }
      str = b();
    } while (str == null);
    this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      tlo.c(this.jdField_a_of_type_JavaLangString, "position:" + a() + ",feedId:" + localstSimpleMetaFeed.id + ",cellId:" + str + ",loadedComments size:" + i + ",mCommentListChanged:" + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      tlo.c(this.jdField_a_of_type_JavaLangString, "11111111111111111111111111 mCommentListChanged");
      a().a(localstSimpleMetaFeed, false);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (this.h)
      {
        tlo.c(this.jdField_a_of_type_JavaLangString, "444444444444444444444444 loadedComments == null and preloading is true");
        c();
        return;
      }
      tlo.c(this.jdField_a_of_type_JavaLangString, "2222222222222222222222222 loadedComments == null and preloading is false");
      a().a(localstSimpleMetaFeed, false);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    tlo.c(this.jdField_a_of_type_JavaLangString, "333333333333333333333 读取评论" + this.jdField_a_of_type_JavaUtilArrayList.size() + "条");
    c();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Tcs != null))
    {
      this.jdField_a_of_type_Tcs.b.clear();
      this.jdField_a_of_type_Tcs.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    this.jdField_e_of_type_Int = paramInt;
    tcs.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.poster.id;
      if (this.jdField_a_of_type_Tcs != null) {
        this.jdField_a_of_type_Tcs.a(paramstSimpleMetaFeed);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(a()), paramstSimpleMetaFeed);
  }
  
  public void a(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      e();
      return;
    }
    tlo.d(this.jdField_a_of_type_JavaLangString, 2, "viewStub is null");
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Tcs != null) {
      this.jdField_a_of_type_Tcs.a(paramString);
    }
  }
  
  public void a(tdt paramtdt)
  {
    this.jdField_a_of_type_Tdt = paramtdt;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject;
    if (paramArrayOfObject[2] == null)
    {
      localObject = "";
      tlo.c(this.jdField_a_of_type_JavaLangString, "handleResponseEvent, action: " + paramArrayOfObject[0] + ",resultCode:" + localInteger + ",msg:" + (String)localObject);
    }
    switch (i)
    {
    case 2: 
    case 7: 
    case 8: 
    default: 
    case 1: 
    case 3: 
    case 5: 
    case 4: 
    case 6: 
      do
      {
        do
        {
          return;
          localObject = (String)paramArrayOfObject[2];
          break;
          b();
          return;
          if (this.jdField_a_of_type_Tdf != null) {
            this.jdField_a_of_type_Tdf.b(this.jdField_a_of_type_AndroidWidgetTextView);
          }
          if (a(5, paramArrayOfObject))
          {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "handleResponseEvent add comment isInterceptEvent");
            return;
          }
          if (localInteger.intValue() != 1000) {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "comment fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          stPostFeedCommentRsp localstPostFeedCommentRsp = (stPostFeedCommentRsp)paramArrayOfObject[3];
          if (localInteger.intValue() == 1000)
          {
            if ((this.jdField_a_of_type_Tcs != null) && (this.jdField_a_of_type_Tcs.a(String.valueOf(paramArrayOfObject[4]), localstPostFeedCommentRsp.comment))) {
              j();
            }
            c(1);
          }
          for (;;)
          {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "ACTION_ADD_FEED_COMMENT, result =" + localInteger + " msg=" + (String)localObject);
            a(localInteger.intValue(), alpo.a(2131702568), (String)localObject);
            return;
            if ((this.jdField_a_of_type_Tcs != null) && (this.jdField_a_of_type_Tcs.a(String.valueOf(paramArrayOfObject[4])))) {
              j();
            }
          }
          if (a(4, paramArrayOfObject))
          {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            if ((this.jdField_a_of_type_Tcs != null) && (this.jdField_a_of_type_Tcs.a(paramArrayOfObject))) {
              j();
            }
            c(-1);
          }
          a(localInteger.intValue(), alpo.a(2131702562), alpo.a(2131702571));
          return;
          if (a(6, paramArrayOfObject))
          {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "handleResponseEvent add reply isInterceptEvent");
            return;
          }
          if (this.jdField_a_of_type_Tdf != null) {
            this.jdField_a_of_type_Tdf.b(this.jdField_a_of_type_AndroidWidgetTextView);
          }
          if (localInteger.intValue() != 1000) {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "reply fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          localObject = ((stPostCommentReplyRsp)paramArrayOfObject[3]).reply;
          paramArrayOfObject = (String)paramArrayOfObject[5];
          tlo.d(this.jdField_a_of_type_JavaLangString, "fakeReplyId:" + paramArrayOfObject + ",reply toString :" + ((stMetaReply)localObject).toString());
          if (localInteger.intValue() == 1000) {
            if ((this.jdField_a_of_type_Tcs != null) && (this.jdField_a_of_type_Tcs.a(((stMetaReply)localObject).id, paramArrayOfObject, (stMetaReply)localObject))) {
              j();
            }
          }
          for (;;)
          {
            a(localInteger.intValue(), alpo.a(2131702561), alpo.a(2131702572));
            return;
            if ((this.jdField_a_of_type_Tcs != null) && (this.jdField_a_of_type_Tcs.a(((stMetaReply)localObject).id, paramArrayOfObject))) {
              j();
            }
          }
          if (a(5, paramArrayOfObject))
          {
            tlo.d(this.jdField_a_of_type_JavaLangString, 1, "handleResponseEvent delete reply isInterceptEvent");
            return;
          }
          a(localInteger.intValue(), alpo.a(2131702567), alpo.a(2131702574));
        } while ((!(paramArrayOfObject[3] instanceof String)) || (!(paramArrayOfObject[4] instanceof stMetaReply)));
        localObject = (String)paramArrayOfObject[3];
        paramArrayOfObject = ((stMetaReply)paramArrayOfObject[4]).id;
      } while ((localInteger.intValue() != 1000) || (this.jdField_a_of_type_Tcs == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArrayOfObject)));
      this.jdField_a_of_type_Tcs.a((String)localObject, paramArrayOfObject);
      j();
      return;
    }
    tlo.d(this.jdField_a_of_type_JavaLangString, "onEvent: ACTION_GET_MORE_COMMENT！");
    i();
    if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(b())))
    {
      tlo.d(this.jdField_a_of_type_JavaLangString, "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
      return;
    }
    if (a(4, paramArrayOfObject))
    {
      i();
      return;
    }
    boolean bool;
    if ((paramArrayOfObject[5] instanceof Boolean))
    {
      bool = ((Boolean)paramArrayOfObject[5]).booleanValue();
      if (!bool) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      if ((paramArrayOfObject[3] instanceof stGetFeedCommentListRsp))
      {
        if (this.jdField_a_of_type_Tcs != null)
        {
          paramArrayOfObject = ((stGetFeedCommentListRsp)paramArrayOfObject[3]).getComments();
          if (paramArrayOfObject.size() != 0) {
            break label1021;
          }
          a(true);
        }
        for (;;)
        {
          if ((!this.jdField_b_of_type_Boolean) || (bool)) {
            break label1051;
          }
          paramArrayOfObject = this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
          if (paramArrayOfObject == null) {
            break;
          }
          paramArrayOfObject.runOnUiThread(new WsCommentPresenter.6(this));
          return;
          label1021:
          if (!bool) {
            this.jdField_a_of_type_Tcs.a();
          }
          this.jdField_a_of_type_Tcs.a(paramArrayOfObject);
          j();
          c(0);
        }
        label1051:
        break;
      }
      tlo.d(this.jdField_a_of_type_JavaLangString, "获取评论response失败");
      return;
      bool = true;
    }
  }
  
  public void b(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    if (this.jdField_b_of_type_Int != -1)
    {
      a(paramViewStub, this.jdField_b_of_type_Int);
      return;
    }
    paramViewStub.setLayoutResource(2131559852);
    this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
    e();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363606: 
      WSPublicAccReport.getInstance().reportCommentPageClick(a(), WSPublicAccReport.getPagePositionId(a()) + this.jdField_e_of_type_Int, 1000001, 7, a());
      a(null, null, true, 2);
      return;
    case 2131363587: 
      WSPublicAccReport.getInstance().reportCommentPageClick(a(), WSPublicAccReport.getPagePositionId(a()) + this.jdField_e_of_type_Int, 1000001, 7, a());
      a(null, null, true, 3);
      return;
    case 2131377631: 
      WSPublicAccReport.getInstance().reportCommentPageClick(a(), WSPublicAccReport.getPagePositionId(a()) + this.jdField_e_of_type_Int, 1000001, 4, a());
      a(null, null, true, 0);
      return;
    }
    WSPublicAccReport.getInstance().reportCommentPageClick(a(), WSPublicAccReport.getPagePositionId(a()) + this.jdField_e_of_type_Int, 1000001, 7, a());
    a(null, null, false, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdn
 * JD-Core Version:    0.7.0.1
 */