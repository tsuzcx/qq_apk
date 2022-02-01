package com.tencent.mobileqq.richstatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureHandler.RspGetHistorySig;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.LikeItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, SoftInputDetectView.OnImStateChangedListener, ISignViewHolder.OnClickListener, ITopic.OnTopicClickListener, AbsListView.OnScrollListener
{
  private View A;
  private TextView B;
  private TextView C;
  private TextView D;
  private boolean E;
  private boolean F;
  private IEmoticonMainPanel G;
  private EditText H;
  private Button I;
  private ImageView J;
  private ViewGroup K;
  private RelativeLayout L;
  private int M = 0;
  private int N;
  private int O = 0;
  private SignatureHistoryFragment.DataAdapter P;
  private Handler Q;
  private HashMap<String, ArrayList<String>> R = new HashMap();
  private HashMap<String, Boolean> S = new HashMap();
  private ArrayList<String> T = new ArrayList();
  private boolean U;
  private CommentItem V;
  private ArrayList<HistorySignItem> W;
  private boolean X = false;
  private QQProgressDialog Y;
  private boolean Z = false;
  protected XListView a;
  private boolean aa = false;
  private HashSet<ISignViewHolder> ab = new HashSet();
  private ActionSheet ac;
  protected int b;
  View c;
  protected SignatureHandler d;
  protected SignatureManager e;
  protected StatusManager f;
  protected StatusObserver g;
  protected SignatureObserver h;
  View.OnTouchListener i = new SignatureHistoryFragment.14(this);
  View.OnClickListener j = new SignatureHistoryFragment.15(this);
  FontLoadCallback k = new SignatureHistoryFragment.16(this);
  View.OnLayoutChangeListener l = new SignatureHistoryFragment.23(this);
  private String m;
  private String n;
  private String o;
  private View p;
  private View q;
  private ImageView r;
  private TextView s;
  private TextView t;
  private int u;
  private View v;
  private TextView w;
  private ImageView x;
  private Drawable y;
  private Button z;
  
  private int a(List<LikeItem> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LikeItem localLikeItem = (LikeItem)paramList.next();
        if ((localLikeItem.b != null) && (paramString.equals(localLikeItem.b.a))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  @NotNull
  private View a(int paramInt, View paramView)
  {
    HistorySignItem localHistorySignItem = (HistorySignItem)this.W.get(paramInt);
    Object localObject1;
    if (paramView == null)
    {
      paramView = new BoxShadowLayout(getBaseActivity());
      localObject1 = b(paramView);
      paramView = new HistorySignViewHolder(getBaseActivity(), getBaseActivity().app, paramView, this.m);
      this.ab.add(paramView);
      paramView.a(this);
      paramView.a(this);
      localObject2 = (LinearLayout)paramView.r();
      paramView.u().setOnTouchListener(this.i);
      paramView.u().setOnClickListener(this);
      LayoutInflater.from(getBaseActivity()).inflate(2131627845, (ViewGroup)localObject2);
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject2 = (HistorySignViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    paramView.d = ((CheckBox)((View)localObject1).findViewById(2131430407));
    a((View)localObject1, localHistorySignItem, paramView);
    paramView.f = ((LikesView)((View)localObject1).findViewById(2131437603));
    paramView.f.setOnItemClickListener(new SignatureHistoryFragment.10(this));
    ((View)localObject1).setTag(paramView);
    ((View)localObject1).setClickable(true);
    a(localHistorySignItem, paramView);
    paramView.b = paramInt;
    paramView.A = this.m;
    Object localObject2 = localHistorySignItem.richStatus;
    paramView.c = ((RichStatus)localObject2);
    paramView.a((RichStatus)localObject2);
    if (((localHistorySignItem.likeItemList != null) && (localHistorySignItem.likeItemList.size() > 0)) || ((localHistorySignItem.commentItemList != null) && (localHistorySignItem.commentItemList.size() > 0)))
    {
      if (paramView.r() != null)
      {
        paramView.r().setVisibility(0);
        paramView.f.a(localHistorySignItem.likeItemList, localHistorySignItem.totalLikeNum);
        paramView.e.a(localHistorySignItem.commentItemList);
      }
    }
    else if (paramView.r() != null) {
      paramView.r().setVisibility(8);
    }
    paramView.y = a(localHistorySignItem.likeItemList, this.n);
    paramView.t();
    return localObject1;
  }
  
  private static IEmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (IEmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new SignatureHistoryFragment.17(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.setDisableGuide(true);
    paramView.setDisableMoreEmotionButton(true);
    paramView.setHasBigEmotion(false);
    paramView.setOnlySysAndEmoji(true);
    paramView.setDisableAutoDownload(true);
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new SignatureHistoryFragment.18());
    paramView.setTabListOverScrollMode(2);
    return paramView;
  }
  
  private void a()
  {
    this.E = false;
    this.F = false;
    if (getTitleBarView() != null) {
      getTitleBarView().setVisibility(8);
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null))
    {
      getBaseActivity().getWindow().setSoftInputMode(16);
      getBaseActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130849331));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
        localSystemBarCompact.init();
        if (ImmersiveUtils.couldSetStatusTextColor())
        {
          ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
          localSystemBarCompact.setStatusBarColor(getResources().getColor(2131168376));
          return;
        }
        localSystemBarCompact.setStatusBarColor(SimpleUIUtil.a);
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.w.setText(HardCodeUtil.a(2131911543));
      this.x.setImageDrawable(this.y);
      this.y.setVisible(true, true);
      return;
    }
    this.y.setVisible(false, false);
    this.x.setImageResource(2130852641);
    if (paramInt == 3)
    {
      this.w.setText(HardCodeUtil.a(2131911535));
      return;
    }
    this.w.setText(HardCodeUtil.a(2131911539));
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = f(this.L);
    this.Q.post(new SignatureHistoryFragment.21(this, paramInt1, i1, paramInt2, paramBoolean));
  }
  
  private void a(Message paramMessage)
  {
    stopTitleProgress();
    this.a.springBackOverScrollHeaderView();
    if (paramMessage.arg1 == 1)
    {
      if (this.W.size() == 0) {
        a(2);
      }
      a(1, 2131916799);
    }
  }
  
  private void a(View paramView, HistorySignItem paramHistorySignItem, HistorySignViewHolder paramHistorySignViewHolder)
  {
    paramHistorySignViewHolder.e = ((CommentsView)paramView.findViewById(2131430862));
    paramHistorySignViewHolder.e.setOnSpanItemClick(new SignatureHistoryFragment.11(this));
    paramHistorySignViewHolder.e.setOnItemClickListener(new SignatureHistoryFragment.12(this, paramHistorySignItem));
    paramHistorySignViewHolder.e.setOnItemLongClickListener(new SignatureHistoryFragment.13(this, paramHistorySignItem));
  }
  
  private void a(View paramView, ISignViewHolder paramISignViewHolder)
  {
    if (this.Z) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
    this.K.setVisibility(0);
    this.L.setVisibility(0);
    this.H.requestFocus();
    this.H.setHint(2131896695);
    d(true);
    int i1 = f(paramView);
    int i2 = paramView.getHeight();
    this.c = paramView;
    this.Q.postDelayed(new SignatureHistoryFragment.9(this, i1, i2), 200L);
    if ((paramISignViewHolder instanceof HistorySignViewHolder))
    {
      paramView = ((HistorySignViewHolder)paramISignViewHolder).c;
      if ((paramView != null) && (getBaseActivity() != null) && (getBaseActivity().app != null))
      {
        this.V = new CommentItem();
        paramISignViewHolder = this.V;
        paramISignViewHolder.targetId = 0L;
        paramISignViewHolder.feedId = paramView.feedsId;
        paramView = this.V;
        paramView.toReplyUser = null;
        paramISignViewHolder = this.n;
        paramView.user = new User(paramISignViewHolder, this.d.b(Long.valueOf(paramISignViewHolder).longValue()));
      }
    }
  }
  
  private void a(SignatureHandler.RspGetHistorySig paramRspGetHistorySig)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      getBaseActivity().app.setVisibilityForStatus(true, true);
    }
    if ((paramRspGetHistorySig != null) && (paramRspGetHistorySig.historySignItems != null)) {
      b(paramRspGetHistorySig);
    }
  }
  
  private void a(HistorySignItem paramHistorySignItem, HistorySignViewHolder paramHistorySignViewHolder)
  {
    if ((paramHistorySignItem != null) && (paramHistorySignItem.richStatus != null) && (paramHistorySignItem.richStatus.feedsId != null)) {
      paramHistorySignViewHolder.d.setTag(paramHistorySignItem.richStatus.feedsId);
    } else {
      paramHistorySignViewHolder.d.setTag("");
    }
    if (this.Z)
    {
      paramHistorySignViewHolder.d.setVisibility(0);
      paramHistorySignViewHolder.d.setOnClickListener(this.j);
    }
    else
    {
      paramHistorySignViewHolder.d.setVisibility(8);
    }
    if ((paramHistorySignItem != null) && (paramHistorySignItem.richStatus != null) && (paramHistorySignItem.richStatus.feedsId != null))
    {
      if (this.T.contains(paramHistorySignItem.richStatus.feedsId))
      {
        paramHistorySignViewHolder.d.setChecked(true);
        return;
      }
      paramHistorySignViewHolder.d.setChecked(false);
      return;
    }
    paramHistorySignViewHolder.d.setChecked(false);
  }
  
  private void a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)))
    {
      Object localObject = this.W;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.W.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HistorySignItem localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
          if ((localHistorySignItem.richStatus != null) && (paramCommentItem.feedId.equals(localHistorySignItem.richStatus.feedsId)))
          {
            if (localHistorySignItem.commentItemList == null) {
              localHistorySignItem.commentItemList = new ArrayList();
            }
            localHistorySignItem.commentItemList.add(paramCommentItem);
          }
        }
      }
    }
  }
  
  private void a(CommentItem paramCommentItem, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(getBaseActivity());
    localActionSheet.addButton(2131889653, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new SignatureHistoryFragment.22(this, paramCommentItem, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(ISignViewHolder paramISignViewHolder)
  {
    if (this.Z) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
    boolean bool = NetworkUtil.isNetSupport(getBaseActivity());
    int i1 = 0;
    if (!bool)
    {
      QQToast.makeText(getBaseActivity(), 2131890731, 0).show();
      return;
    }
    if ((paramISignViewHolder instanceof HistorySignViewHolder))
    {
      paramISignViewHolder = (HistorySignViewHolder)paramISignViewHolder;
      if (paramISignViewHolder.y == 0)
      {
        paramISignViewHolder.y = 1;
        i1 = 1;
      }
      else
      {
        paramISignViewHolder.y = 0;
      }
      if ((paramISignViewHolder.c != null) && (!TextUtils.isEmpty(paramISignViewHolder.c.feedsId)))
      {
        a(paramISignViewHolder.c.feedsId, this.n, paramISignViewHolder.y);
        Object localObject = this.P;
        if (localObject != null) {
          ((SignatureHistoryFragment.DataAdapter)localObject).notifyDataSetChanged();
        }
        localObject = this.d;
        if (localObject != null) {
          ((SignatureHandler)localObject).a(this.m, paramISignViewHolder.c.feedsId, 255, i1);
        }
      }
    }
  }
  
  private void a(Integer paramInteger, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.ac = ActionSheet.create(getBaseActivity());
    int i2 = paramInteger.intValue();
    int i1 = 1;
    if (i2 == 2)
    {
      this.ac.addRadioButton(2131888830, false);
    }
    else if (paramBoolean)
    {
      if (paramInt1 > 1)
      {
        this.ac.addRadioButton(2131888827, false);
        i1 = 3;
      }
      else
      {
        this.ac.addRadioButton(2131888829, false);
        i1 = 2;
      }
    }
    else
    {
      this.ac.addRadioButton(2131888826, false);
      i1 = 4;
    }
    this.ac.addCancelButton(2131887648);
    this.ac.show();
    this.ac.setOnButtonClickListener(new SignatureHistoryFragment.7(this, i1, paramInt1, paramInt2));
    this.ac.setOnDismissListener(new SignatureHistoryFragment.8(this));
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1)))
    {
      Object localObject = this.W;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.W.iterator();
        HistorySignItem localHistorySignItem;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
        } while ((localHistorySignItem.richStatus == null) || (!paramString1.equals(localHistorySignItem.richStatus.feedsId)) || (!a(paramString2, paramInt, localHistorySignItem, localHistorySignItem.likeItemList)));
      }
    }
  }
  
  private void a(List<byte[]> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      byte[] arrayOfByte = (byte[])paramList.next();
      Iterator localIterator = this.W.iterator();
      if (localIterator.hasNext())
      {
        HistorySignItem localHistorySignItem = (HistorySignItem)localIterator.next();
        if ((localHistorySignItem == null) || (localHistorySignItem.richStatus == null) || (!localHistorySignItem.richStatus.feedsId.equals(new String(arrayOfByte)))) {
          break;
        }
        localIterator.remove();
      }
    }
  }
  
  private void a(boolean paramBoolean, List<byte[]> paramList)
  {
    QQProgressDialog localQQProgressDialog = this.Y;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.Y.dismiss();
    }
    if ((paramBoolean) && (paramList != null))
    {
      if (getBaseActivity() != null) {
        a(2, 2131888446);
      }
      a(paramList);
      if (this.W.size() == 0) {
        a(3);
      }
      this.T.clear();
      this.Z = false;
      this.D.setText(2131916678);
      f(false);
      paramList = this.P;
      if (paramList != null) {
        paramList.notifyDataSetChanged();
      }
    }
    else if (getBaseActivity() != null)
    {
      a(1, 2131897219);
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean)
  {
    if ((!this.E) && (!this.F) && (this.K.getVisibility() != 0)) {
      return false;
    }
    EditText localEditText = this.H;
    if ((localEditText != null) && (paramBoolean)) {
      localEditText.setText("");
    }
    this.F = false;
    this.E = false;
    InputMethodUtil.b(paramView);
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.L.setVisibility(8);
    this.L.removeOnLayoutChangeListener(this.l);
    return true;
  }
  
  private boolean a(CommentItem paramCommentItem, HistorySignItem paramHistorySignItem)
  {
    if ((paramHistorySignItem.richStatus != null) && (paramCommentItem.feedId.equals(paramHistorySignItem.richStatus.feedsId)) && (paramHistorySignItem.commentItemList != null) && (paramHistorySignItem.commentItemList.size() > 0))
    {
      paramHistorySignItem = paramHistorySignItem.commentItemList.iterator();
      while (paramHistorySignItem.hasNext()) {
        if (((CommentItem)paramHistorySignItem.next()).id == paramCommentItem.id)
        {
          paramHistorySignItem.remove();
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt, HistorySignItem paramHistorySignItem, List<LikeItem> paramList)
  {
    Object localObject = paramList;
    if (paramInt == 1)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
    }
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      if (paramInt == 0)
      {
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (LikeItem)paramList.next();
          if ((((LikeItem)localObject).b != null) && (paramString.equals(((LikeItem)localObject).b.a)))
          {
            paramList.remove();
            paramHistorySignItem.totalLikeNum -= 1L;
            return true;
          }
        }
        return false;
      }
      ((List)localObject).add(0, new LikeItem(NetConnInfoCenter.getServerTime() / 1000L, new User(paramString, a(paramString))));
      paramHistorySignItem.totalLikeNum += 1L;
    }
    return true;
  }
  
  private boolean a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Iterator localIterator = this.T.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null)
      {
        ArrayList localArrayList = this.W;
        if ((localArrayList != null) && (localArrayList.get(0) != null) && (((HistorySignItem)this.W.get(0)).richStatus != null) && (((HistorySignItem)this.W.get(0)).richStatus.feedsId != null))
        {
          if (str.equals(new String(((HistorySignItem)this.W.get(0)).richStatus.feedsId))) {
            paramBoolean = true;
          }
          paramArrayList.add(str);
        }
      }
    }
    return paramBoolean;
  }
  
  private void b()
  {
    this.L = ((RelativeLayout)this.mContentView.findViewById(2131445027));
    this.L.setVisibility(8);
    this.H = ((EditText)this.mContentView.findViewById(2131432616));
    this.H.setEditableFactory(new SignatureHistoryFragment.2(this));
    this.H.addTextChangedListener(new SignatureHistoryFragment.3(this));
    this.I = ((Button)this.mContentView.findViewById(2131430010));
    this.I.setOnClickListener(this);
    Button localButton = this.I;
    localButton.setEnabled(TextUtils.isEmpty(localButton.getText()) ^ true);
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage.arg1 == 1)
    {
      a(1, 2131902417);
      return;
    }
    if (paramMessage.arg1 == 2) {
      a(1, 2131894148);
    }
  }
  
  private void b(SignatureHandler.RspGetHistorySig paramRspGetHistorySig)
  {
    boolean bool = paramRspGetHistorySig.over;
    paramRspGetHistorySig = paramRspGetHistorySig.historySignItems;
    if ((this.U) && (this.W.size() > 0)) {
      this.W.clear();
    }
    if (this.W.size() > 0)
    {
      localObject1 = paramRspGetHistorySig.iterator();
      Object localObject2 = this.W;
      localObject2 = ((HistorySignItem)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).richStatus;
      if (localObject2 != null) {
        while (((Iterator)localObject1).hasNext())
        {
          RichStatus localRichStatus = ((HistorySignItem)((Iterator)localObject1).next()).richStatus;
          if ((localRichStatus.time <= ((RichStatus)localObject2).time) && ((localRichStatus.time != ((RichStatus)localObject2).time) || (!Arrays.equals(localRichStatus.encode(), ((RichStatus)localObject2).encode())))) {
            break;
          }
          ((Iterator)localObject1).remove();
        }
      }
    }
    Object localObject1 = this.W;
    ((ArrayList)localObject1).addAll(((ArrayList)localObject1).size(), paramRspGetHistorySig);
    this.O = (bool ^ true);
  }
  
  private void b(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.Q.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(1, 2131916799);
    this.a.springBackOverScrollHeaderView();
  }
  
  private boolean b(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)))
    {
      Object localObject = this.W;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.W.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (a(paramCommentItem, (HistorySignItem)((Iterator)localObject).next())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    ThreadManager.getFileThreadHandler().post(new SignatureHistoryFragment.4(this));
  }
  
  private void c(Message paramMessage)
  {
    if (isAdded())
    {
      if (paramMessage.arg1 >= 0)
      {
        this.t.setVisibility(0);
        this.t.setText(String.format(getString(2131916676), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return;
      }
      this.t.setVisibility(8);
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!NetworkUtil.isNetSupport(getBaseActivity()))
        {
          QQToast.makeText(getBaseActivity(), getString(2131889169), 0).show();
          return;
        }
        CommentItem localCommentItem = this.V;
        if (localCommentItem != null)
        {
          localCommentItem.content = ((String)localObject);
          if (this.d != null)
          {
            if (this.Y == null) {
              this.Y = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            }
            this.Y.a(null);
            this.Y.show();
            this.d.a(Long.valueOf(this.m).longValue(), this.V.feedId, this.V.targetId, Long.valueOf(this.n).longValue(), this.V.content);
          }
          a(paramView, true);
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((getActivity() != null) && (!TextUtils.isEmpty(getBaseActivity().getCurrentAccountUin())) && (getBaseActivity().getCurrentAccountUin().equals(paramString))) {
      paramString = new AllInOne(paramString, 0);
    } else if (b(paramString)) {
      paramString = new AllInOne(paramString, 1);
    } else {
      paramString = new AllInOne(paramString, 19);
    }
    ProfileUtils.openProfileCard(getActivity(), paramString);
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = this.a.getFirstVisiblePosition();
    int i3 = this.a.getLastVisiblePosition();
    int i4 = this.a.getHeaderViewsCount();
    int i1 = i2 - 1;
    while (i1 <= i3)
    {
      Object localObject = this.a.getChildAt(i4 + i1 - i2);
      if ((localObject != null) && ((((View)localObject).getTag() instanceof HistorySignViewHolder)))
      {
        localObject = (HistorySignViewHolder)((View)localObject).getTag();
        ((HistorySignViewHolder)localObject).b(paramBoolean);
        if (((HistorySignViewHolder)localObject).p != null) {
          if (paramBoolean)
          {
            ((HistorySignViewHolder)localObject).p.pauseAnimation();
          }
          else
          {
            ((HistorySignViewHolder)localObject).p.shouldStartAnimation = true;
            ((HistorySignViewHolder)localObject).p.startAnimation(false, false);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void d()
  {
    Object localObject2 = this.o;
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() == 0) {
      localObject1 = String.valueOf(this.m);
    }
    this.s.setText((CharSequence)localObject1);
    this.s.invalidate();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getBaseActivity().getString(2131888119));
    ((StringBuilder)localObject2).append(":");
    localObject2 = ((StringBuilder)localObject2).toString();
    TextView localTextView = this.s;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append((String)localObject1);
    localTextView.setContentDescription(localStringBuilder.toString());
  }
  
  private void d(View paramView)
  {
    int i3 = 0;
    this.aa = false;
    Object localObject2 = paramView.getTag(2131446003);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = Integer.valueOf(0);
        if (paramView.getTag(2131446006) != null)
        {
          int i2 = ((Integer)paramView.getTag(2131446006)).intValue();
          i1 = i2;
          if (i2 <= 1) {
            break label161;
          }
          bool1 = true;
          i1 = i2;
          i2 = i3;
          boolean bool2 = bool1;
          if (paramView.getTag(2131446004) != null)
          {
            i3 = ((Integer)paramView.getTag(2131446004)).intValue();
            i2 = i3;
            bool2 = bool1;
            if (i3 > 0)
            {
              bool2 = true;
              i2 = i3;
            }
          }
          if ((this.ac != null) && (this.ac.isShowing())) {
            return;
          }
          a((Integer)localObject1, i1, i2, bool2);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      int i1 = 1;
      label161:
      boolean bool1 = false;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(false);
      InputMethodUtil.a(this.H);
      return;
    }
    InputMethodUtil.b(this.H);
  }
  
  @NotNull
  private View e(View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = getBaseActivity().getLayoutInflater().inflate(2131625460, null);
      localView.setBackgroundColor(getResources().getColor(2131168376));
      paramView = new SignatureHistoryFragment.MoreViewHolder();
      localView.setTag(paramView);
      paramView.a = ((ProgressBar)localView.findViewById(2131444560));
      localView.findViewById(2131437616).setVisibility(8);
      paramView.b = ((TextView)localView.findViewById(2131438894));
      paramView.b.setTextColor(getResources().getColor(2131165564));
    }
    if (this.O == 1)
    {
      this.O = 2;
      a(false, false);
    }
    paramView = (SignatureHistoryFragment.MoreViewHolder)localView.getTag();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    int i1 = this.O;
    if (i1 == 3)
    {
      paramView.a.setVisibility(8);
      paramView.b.setText(HardCodeUtil.a(2131911532));
      localLayoutParams.height = AIOUtils.b(60.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      return localView;
    }
    if (i1 == 2)
    {
      paramView.a.setVisibility(0);
      paramView.b.setText(HardCodeUtil.a(2131911518));
      localLayoutParams.height = AIOUtils.b(60.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      return localView;
    }
    if (i1 == 0)
    {
      paramView.a.setVisibility(8);
      paramView.b.setVisibility(8);
      localLayoutParams.height = (ScreenUtil.SCREEN_HIGHT / 4);
      localView.setLayoutParams(localLayoutParams);
    }
    return localView;
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.m)) && (!this.Z)) {
      c(this.m);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.E)
      {
        this.M = 1;
        d(false);
        return;
      }
      j();
      return;
    }
    this.F = false;
    this.J.setImageResource(2130852006);
    this.J.setContentDescription(getBaseActivity().getString(2131887157));
    this.J.setOnClickListener(new SignatureHistoryFragment.19(this));
    this.G.getView().setVisibility(8);
  }
  
  private int f(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void f()
  {
    if ((this.V != null) && (getBaseActivity() != null))
    {
      ((ClipboardManager)getBaseActivity().getSystemService("clipboard")).setText(this.V.content);
      this.V = null;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.A.setVisibility(8);
      return;
    }
    if (this.Z)
    {
      this.A.setVisibility(0);
      ArrayList localArrayList = this.T;
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        this.z.setTextColor(getBaseActivity().getResources().getColor(2131167953));
        this.z.setText(String.format(getBaseActivity().getResources().getString(2131916675), new Object[] { Integer.valueOf(this.T.size()) }));
        this.z.setOnTouchListener(UITools.a);
      }
      else
      {
        this.z.setTextColor(getBaseActivity().getResources().getColor(2131167954));
        this.z.setText(getString(2131916673));
        this.z.setOnTouchListener(null);
      }
      this.z.setBackgroundResource(2130849327);
      return;
    }
    if (this.m.equals(this.n))
    {
      this.A.setVisibility(0);
      this.z.setText(getString(2131915721));
      this.z.setTextColor(getResources().getColor(2131168464));
      this.z.setBackgroundResource(2130839460);
      return;
    }
    this.A.setVisibility(8);
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      QQToast.makeText(getBaseActivity(), 2131890731, 0).show();
      return;
    }
    if ((this.V != null) && (!TextUtils.isEmpty(this.m)) && (!TextUtils.isEmpty(this.n)))
    {
      if (this.Y == null) {
        this.Y = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      }
      this.Y.a(null);
      this.Y.show();
      this.d.a(Long.valueOf(this.m).longValue(), this.V.feedId, Long.valueOf(this.n).longValue(), this.V.id);
    }
  }
  
  private void h()
  {
    if (this.Z) {
      synchronized (this.T)
      {
        if (this.T.isEmpty()) {
          return;
        }
        if (!NetworkUtil.isNetSupport(getBaseActivity()))
        {
          QQToast.makeText(getBaseActivity(), getString(2131889169), 0).show();
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
        i().show();
        return;
      }
    }
    VasWebviewUtil.a("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    SignatureEditManager.a(getBaseActivity(), getBaseActivity().app, 0, "signature_history");
  }
  
  private QQCustomDialog i()
  {
    return DialogUtil.a(getBaseActivity(), 230).setTitle(getString(2131916674)).setPositiveButton(getString(2131887718), new SignatureHistoryFragment.6(this)).setNegativeButton(getString(2131887648), new SignatureHistoryFragment.5(this));
  }
  
  private void j()
  {
    this.F = true;
    this.J.setImageResource(2130837628);
    this.J.setContentDescription(getBaseActivity().getString(2131887158));
    this.J.setOnClickListener(new SignatureHistoryFragment.20(this));
    this.G.getView().setVisibility(0);
    int i1;
    if (this.N > ScreenUtil.SCREEN_HIGHT / 4) {
      i1 = this.N;
    } else {
      i1 = ScreenUtil.SCREEN_HIGHT / 3;
    }
    ViewGroup.LayoutParams localLayoutParams = this.G.getView().getLayoutParams();
    localLayoutParams.height = i1;
    this.G.getView().setMinimumHeight(localLayoutParams.height);
    this.G.getView().setLayoutParams(localLayoutParams);
    ((RelativeLayout.LayoutParams)this.L.getLayoutParams()).bottomMargin = i1;
    this.M = 0;
  }
  
  private void k()
  {
    this.Z ^= true;
    if (this.Z)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      f(false);
      this.D.setText(2131889474);
    }
    else
    {
      f(false);
      this.D.setText(2131916678);
      this.T.clear();
    }
    this.P.notifyDataSetChanged();
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return paramString;
      }
      Friends localFriends = ((FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
      str = paramString;
      if (localFriends != null) {
        str = localFriends.getFriendNickWithAlias();
      }
    }
    return str;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().isResume())) {
      QQToast.makeText(getBaseActivity(), paramInt1, getResources().getString(paramInt2), 0).show(getBaseActivity().getTitleBarHeight());
    }
  }
  
  public void a(View paramView)
  {
    if (this.m.equals(this.n)) {
      return;
    }
    VasWebviewUtil.a("signature_history", "cove_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    if (!this.aa) {
      return;
    }
    d(paramView);
  }
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      a(paramView, paramISignViewHolder);
      return;
    }
    if (paramInt == 4)
    {
      a(paramISignViewHolder);
      return;
    }
    if ((paramInt == 2) && ((paramISignViewHolder instanceof HistorySignViewHolder)) && (this.ac == null))
    {
      this.aa = true;
      a(((HistorySignViewHolder)paramISignViewHolder).u());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    View localView = localBaseActivity.findViewById(2131439329);
    if (paramBoolean)
    {
      if (localView == null)
      {
        localView = new View(getBaseActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131439329);
        localBaseActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      localView.setVisibility(0);
      return;
    }
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)this.L.getLayoutParams()).bottomMargin = 0;
      this.N = paramInt;
      e(false);
      f(true);
    }
    else
    {
      if (this.M == 1) {
        j();
      } else {
        this.L.setVisibility(8);
      }
      f(false);
    }
    this.E = paramBoolean;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateData: refresh=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" user=");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("SignatureHistoryFragment", 2, ((StringBuilder)localObject).toString());
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      this.U = paramBoolean1;
      long l1;
      if (paramBoolean1)
      {
        l1 = 2147483647L;
      }
      else
      {
        localObject = this.W;
        l1 = ((HistorySignItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).richStatus.time - 1L;
      }
      int i1 = (int)l1;
      this.d.a(Long.valueOf(this.m).longValue(), 0, i1);
    }
    else
    {
      localObject = this.Q.obtainMessage(0, 1, 0);
      this.Q.sendMessageDelayed((Message)localObject, 1000L);
      if (!paramBoolean1)
      {
        this.O = 3;
        localObject = this.P;
        if (localObject != null) {
          ((SignatureHistoryFragment.DataAdapter)localObject).notifyDataSetChanged();
        }
      }
    }
    if (this.W.size() == 0) {
      a(1);
    }
    if (paramBoolean2)
    {
      stopTitleProgress();
      return;
    }
    if (paramBoolean1) {
      startTitleProgress();
    }
  }
  
  public LinearLayout b(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getBaseActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getBaseActivity()).inflate(2131627844, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = AIOUtils.b(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i1 = AIOUtils.b(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(ViewUtils.getScreenWidth() - i1 * 2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
    ((LinearLayout.LayoutParams)localObject).rightMargin = i1;
    localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
    return localLinearLayout;
  }
  
  public boolean b(String paramString)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      return ((FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString);
    }
    return false;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.Q = new Handler(this);
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return;
      }
      ((IFontManagerService)getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).addFontLoadCallback(this.k);
      this.W = new ArrayList();
      this.o = getBaseActivity().getIntent().getStringExtra("key_uin_name");
      this.m = getBaseActivity().getIntent().getStringExtra("key_uin");
      this.n = getBaseActivity().app.getCurrentUin();
      paramLayoutInflater = getBaseActivity().getIntent().getStringExtra("key_open_via");
      VasWebviewUtil.a(getBaseActivity().app.getCurrentUin(), "signature", "signature_8", paramLayoutInflater, 1, 0, 0, "", "", "");
      boolean bool = this.n.equalsIgnoreCase(this.m);
      int i2 = 2;
      if (bool) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i1, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165564));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130841082));
      this.centerView.setTextColor(getResources().getColor(2131165564));
      paramLayoutInflater = new DisplayMetrics();
      getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      int i1 = paramLayoutInflater.widthPixels;
      int i3 = DisplayUtil.a(getBaseActivity(), 69.0F);
      this.u = Math.min(DisplayUtil.a(getBaseActivity(), 260.0F), i1 - i3);
      this.b = ((this.u - DisplayUtil.a(getBaseActivity(), 70.0F)) / DisplayUtil.a(getBaseActivity(), 28.0F));
      this.e = ((SignatureManager)getBaseActivity().app.getManager(QQManagerFactory.SIGNATURE_MANAGER));
      this.f = ((StatusManager)getBaseActivity().app.getManager(QQManagerFactory.STATUS_MANAGER));
      this.d = ((SignatureHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER));
      this.g = new SignatureHistoryFragment.MyStatusObserver(this, null);
      getBaseActivity().app.registObserver(this.g);
      this.h = new SignatureHistoryFragment.MySignatureObserver(this, null);
      getBaseActivity().app.addObserver(this.h);
      this.C = ((TextView)this.mContentView.findViewById(2131448750));
      this.C.setText(2131916677);
      this.D = ((TextView)this.mContentView.findViewById(2131448749));
      this.D.setOnClickListener(this);
      this.B = ((TextView)this.mContentView.findViewById(2131448748));
      this.B.setOnClickListener(this);
      this.B.setContentDescription(getText(2131887625));
      i1 = UIUtils.a(getBaseActivity(), 3.0F);
      i3 = UIUtils.a(getBaseActivity(), 10.0F);
      UIUtils.a(this.B, i1, i1, i3, i3);
      if (this.m.equals(this.n))
      {
        this.D.setVisibility(0);
        this.D.setText(2131916678);
      }
      else
      {
        this.D.setVisibility(8);
      }
      this.v = LayoutInflater.from(getBaseActivity()).inflate(2131629306, this.a, false);
      this.w = ((TextView)this.v.findViewById(2131432517));
      this.w.setCompoundDrawables(null, null, null, null);
      this.x = ((ImageView)this.v.findViewById(2131432506));
      this.y = getResources().getDrawable(2130839590);
      this.x.setImageDrawable(this.y);
      this.y.setVisible(true, true);
      this.z = ((Button)this.mContentView.findViewById(2131445990));
      this.z.setOnClickListener(this);
      this.A = this.mContentView.findViewById(2131445989);
      f(false);
      this.q = LayoutInflater.from(getBaseActivity()).inflate(2131629307, null);
      this.r = ((ImageView)this.q.findViewById(2131445987));
      this.r.setOnClickListener(this);
      this.s = ((TextView)this.q.findViewById(2131445988));
      this.t = ((TextView)this.q.findViewById(2131445997));
      this.a = ((XListView)this.mContentView.findViewById(2131431351));
      this.a.addHeaderView(this.q, null, false);
      this.P = new SignatureHistoryFragment.DataAdapter(this, null);
      this.a.setAdapter(this.P);
      this.a.setOnScrollListener(this);
      this.p = this.mContentView.findViewById(2131447797);
      this.p.setOnTouchListener(new SignatureHistoryFragment.1(this));
      b();
      this.K = ((ViewGroup)this.mContentView.findViewById(2131432441));
      this.K.setVisibility(8);
      this.J = ((ImageView)this.mContentView.findViewById(2131432469));
      this.J.setOnTouchListener(UITools.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131435828);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.G = a(getBaseActivity().app, getBaseActivity(), this.mContentView, 2131432442, this.H);
      this.G.getView().setVisibility(8);
      a();
      c();
      paramLayoutInflater = this.o;
      if ((paramLayoutInflater == null) || (paramLayoutInflater.equals(""))) {
        this.o = ContactUtils.d(getBaseActivity().app, this.m);
      }
      d();
      paramLayoutInflater = this.d;
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(Long.parseLong(this.m));
      }
      i1 = i2;
      if (this.m.equals(this.n)) {
        i1 = 1;
      }
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("");
      paramLayoutInflater.append(i1);
      ReportController.b(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i1, 0, paramLayoutInflater.toString(), "0", "", "");
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("");
      paramLayoutInflater.append(i1);
      VasWebviewUtil.a("signature_history", "pv", "", 0, 0, 0, "", "", paramLayoutInflater.toString(), "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131629310;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return true;
            }
            b(paramMessage);
            return true;
          }
          c(paramMessage);
          return true;
        }
        this.r.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      }
      this.P.notifyDataSetChanged();
      return true;
    }
    a(paramMessage);
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
  }
  
  public boolean onBackEvent()
  {
    if ((!getBaseActivity().isFinishing()) && (this.G.getView().getVisibility() == 0))
    {
      e(false);
      return true;
    }
    if (("history-msglist".equalsIgnoreCase(getBaseActivity().getIntent().getStringExtra("key_open_via"))) && (getBaseActivity() != null))
    {
      Object localObject = this.m;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.n)))
      {
        localObject = new AllInOne(this.m, 0);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getBaseActivity(), (AllInOne)localObject, localBundle);
        getBaseActivity().overridePendingTransition(2130772005, 2130772006);
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131448749: 
      k();
      break;
    case 2131448748: 
      onBackEvent();
      break;
    case 2131446003: 
      a(paramView);
      break;
    case 2131445990: 
      h();
      break;
    case 2131445987: 
      e();
      break;
    case 2131431695: 
      g();
      break;
    case 2131431492: 
      f();
      break;
    case 2131430010: 
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    if (this.Z) {
      return;
    }
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramITopic });
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      if (QLog.isColorLevel()) {
        QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramITopic.first, paramITopic.second }));
      }
      TopicUtil.a(getBaseActivity(), TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.ab.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ISignViewHolder)((Iterator)localObject).next()).v();
    }
    getBaseActivity().app.unRegistObserver(this.g);
    getBaseActivity().app.removeObserver(this.h);
    ((IFontManagerService)getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).removeFontLoadCallback(this.k);
    localObject = this.Q;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a(true, false);
    if ((getBaseActivity() != null) && (getBaseActivity().app != null)) {
      a(ThemeUtil.isInNightMode(getBaseActivity().app));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      VasFaceManager.b();
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      c(false);
      return;
    }
    URLDrawable.pause();
    VasFaceManager.a();
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */