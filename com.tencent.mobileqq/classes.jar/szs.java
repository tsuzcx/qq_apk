import android.app.Activity;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class szs
  extends tav<CommentEntry>
  implements IEventReceiver
{
  public int a;
  public Activity a;
  public TextView a;
  public CommentLikeFeedItem a;
  public InnerListView a;
  public List<CommentEntry> a;
  public sze a;
  public szm a;
  public szo a;
  public szw a;
  protected szx a;
  private tad jdField_a_of_type_Tad;
  protected tbw a;
  protected tcl a;
  private upz jdField_a_of_type_Upz;
  private urq jdField_a_of_type_Urq;
  private boolean jdField_a_of_type_Boolean;
  public List<CommentEntry> b = new ArrayList();
  public List<StoryVideoItem> c;
  
  public szs(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tbw = ((tbw)tcz.a(17));
    this.jdField_a_of_type_Tcl = ((tcl)tcz.a(15));
    this.jdField_a_of_type_Urq = new urq();
    this.jdField_a_of_type_Upz = new upz(paramActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, true);
    this.c = paramList;
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    if (paramInt == 12) {
      i = 3;
    }
    while ((paramInt != 210) && (paramInt != 222) && (paramInt != 23) && (paramInt != 220) && (paramInt != 221) && (paramInt != 211)) {
      return i;
    }
    return 2;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = new tae(a(paramInt1), paramString, paramInt2);
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      paramString.c = paramInt3;
    }
    stb.a().dispatch(paramString);
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, boolean paramBoolean, int paramInt, szr paramszr)
  {
    b(paramCommentLikeFeedItem, paramCommentEntry, paramInt, paramszr, true, paramBoolean);
    int i;
    if (paramCommentEntry.isReply())
    {
      paramInt = 2;
      if (!paramBoolean) {
        break label101;
      }
      i = 12;
      label27:
      if (!paramCommentLikeFeedItem.getOwner().isMe()) {
        break label110;
      }
      paramszr = "1";
      label43:
      if (!a(paramCommentEntry.content)) {
        break label117;
      }
    }
    label101:
    label110:
    label117:
    for (paramCommentEntry = "2";; paramCommentEntry = "1")
    {
      vei.a("home_page", "send_comment", i, paramInt, new String[] { paramszr, paramCommentEntry, tau.a().a, paramCommentLikeFeedItem.feedId });
      return;
      paramInt = 1;
      break;
      i = vei.a(paramCommentLikeFeedItem);
      break label27;
      paramszr = "2";
      break label43;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label42;
      }
      int k = paramString.charAt(i);
      if (ayjy.a.get(k, -1) < 0) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, szr paramszr, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    sze.b(paramCommentEntry, new szu(paramszr, paramCommentEntry, (tbw)tcz.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public taw a()
  {
    this.jdField_a_of_type_Sze = new sze(this);
    return this.jdField_a_of_type_Sze;
  }
  
  public tax a()
  {
    this.jdField_a_of_type_Szm = new szm(this);
    return this.jdField_a_of_type_Szm;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Szx != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Szx);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("FeedCommentLego", 1, "deleteComment but index is : " + paramInt + " and commentlist size is" + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "deleteCommentData: " + localCommentEntry);
    }
    if (localCommentEntry.status != 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      e();
      bcql.a(BaseApplication.getContext(), 2, ajya.a(2131704406), 0).a();
      this.jdField_a_of_type_Tbw.d(localCommentEntry);
      tao.a().a();
      a(this.jdField_a_of_type_Int, 2, localCommentEntry.feedId, localCommentEntry.commentId);
      return;
    }
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704412), 0).a();
      ved.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    localCommentEntry.status = 1;
    e();
    sze.a(localCommentEntry, new szv(this, paramInt, localCommentEntry));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364499));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOverScrollMode(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370358));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Szx = new szx(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Szx);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    if (this.jdField_a_of_type_Szm != null) {
      this.jdField_a_of_type_Szm.a(paramCommentLikeFeedItem);
    }
    this.jdField_a_of_type_Upz.a(paramCommentLikeFeedItem);
    this.c = paramList;
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (aylc.a(paramString))
    {
      localCommentEntry.content = axau.a(paramString);
      label31:
      localCommentEntry.replyTime = System.currentTimeMillis();
      if (paramCommentEntry != null)
      {
        localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
        localCommentEntry.replierName = paramCommentEntry.authorName;
        localCommentEntry.replierRole = paramCommentEntry.authorRole;
      }
      localCommentEntry.authorUin = QQStoryContext.a().c();
      localCommentEntry.authorUnionId = QQStoryContext.a().b();
      localCommentEntry.status = 1;
      localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      localCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
      if (((Integer)((tcs)tcz.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
        localCommentEntry.authorRole = 2;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment != 1) {
        break label247;
      }
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704405), 0).a();
      localCommentEntry.status = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      e();
      this.jdField_a_of_type_Tbw.b(localCommentEntry);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedCommentLego", 2, "AddComment: " + localCommentEntry.toString());
      return;
      localCommentEntry.content = paramString;
      break label31;
      label247:
      tau.a().a = "";
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, localCommentEntry, false, this.jdField_a_of_type_Int, new szt(this));
    }
  }
  
  public void a(List<CommentEntry> paramList)
  {
    a(paramList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemClickListener(this.jdField_a_of_type_Szm);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemLongClickListener(this.jdField_a_of_type_Szm);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Szm);
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "renderCommentList:" + paramList);
    }
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_Szw == null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.a(2131561239, 2);
      this.jdField_a_of_type_Szw = new szw(this, 2131561239, this.jdField_a_of_type_JavaUtilList, true);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Szw);
    }
    for (;;)
    {
      e();
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilList = paramList;
      } else {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
    }
  }
  
  public void a(szo paramszo)
  {
    this.jdField_a_of_type_Szo = paramszo;
  }
  
  public void a(tad paramtad)
  {
    this.jdField_a_of_type_Tad = paramtad;
  }
  
  public void a(tax paramtax)
  {
    super.a(paramtax);
    this.jdField_a_of_type_Szm = ((szm)paramtax);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    szy localszy = (szy)a();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean) {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    for (localCommentLikeFeedItem.mCommentCount += 1;; localCommentLikeFeedItem.mCommentCount -= 1)
    {
      localszy.a(null);
      if (paramCommentEntry != null) {
        localszy.a.a(paramCommentEntry);
      }
      return;
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704399), 0).a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Szw = new szw(this, 2131561239, this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Szw);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Szw = new szw(this, 2131561239, this.jdField_a_of_type_JavaUtilList, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Szw);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szs
 * JD-Core Version:    0.7.0.1
 */