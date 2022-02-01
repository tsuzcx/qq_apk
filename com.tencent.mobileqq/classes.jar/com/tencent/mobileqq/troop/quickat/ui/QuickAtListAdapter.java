package com.tencent.mobileqq.troop.quickat.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QuickAtListAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  public boolean a = false;
  QQAppInterface b;
  LinkedHashMap<ChatHistoryTroopMemberFragment.ATroopMember, AtTag> c;
  AtPanelListener d;
  String e;
  boolean f;
  private final AllMemberItemViewWrapper g;
  private final ListViewWrapper h;
  private int[] i = new int[0];
  private String[] j = new String[0];
  private Context k;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> l;
  private final TroopChatPie m;
  private TroopInfo p;
  private boolean q;
  private QuickAtListHelper r;
  private int s = 0;
  
  public QuickAtListAdapter(ListViewWrapper paramListViewWrapper, TroopChatPie paramTroopChatPie)
  {
    super(paramListViewWrapper.d, paramListViewWrapper.c, paramListViewWrapper.a, true);
    this.b = paramListViewWrapper.c;
    this.k = paramListViewWrapper.d;
    this.h = paramListViewWrapper;
    this.m = paramTroopChatPie;
    k();
    this.l = new ArrayList();
    this.c = new LinkedHashMap();
    this.g = new AllMemberItemViewWrapper(this.m, this.p, this.b, this);
    this.r = new QuickAtListHelper(this);
    i();
  }
  
  private void a(int paramInt, QuickAtListAdapter.ViewHolder paramViewHolder)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.l.get(paramInt);
    paramViewHolder.A.setImageBitmap(a(localATroopMember.a, 2));
    Object localObject = AtUtil.b(localATroopMember);
    if (this.s == 1) {
      localObject = localATroopMember.S;
    }
    localObject = new ColorNickText((CharSequence)localObject, 16).b();
    paramViewHolder.b.setText((CharSequence)localObject);
    ColorNickManager.a(paramViewHolder.b, (Spannable)localObject, localATroopMember.o);
    paramViewHolder.y = localATroopMember.a;
    paramViewHolder.c = paramInt;
    QuickAtListAdapter.ViewHolder.a(paramViewHolder).setTag(paramViewHolder);
    QuickAtListAdapter.ViewHolder.a(paramViewHolder).setOnClickListener(this);
    localObject = this.b;
    Context localContext = this.k;
    VipUtils.a((QQAppInterface)localObject, localContext, localContext.getResources(), paramViewHolder, localATroopMember);
    c(paramViewHolder, localATroopMember);
    if (this.c.containsKey(localATroopMember)) {
      paramViewHolder.a.setChecked(true);
    } else {
      paramViewHolder.a.setChecked(false);
    }
    if (!this.r.b) {
      paramViewHolder.a.setVisibility(8);
    } else {
      paramViewHolder.a.setVisibility(0);
    }
    a(paramViewHolder, localATroopMember);
    b(paramViewHolder, localATroopMember);
  }
  
  private void a(View paramView)
  {
    paramView = ((QuickAtListAdapter.ViewHolder)paramView.getTag()).a;
    if ((this.r.c()) && (!paramView.isChecked()))
    {
      this.r.b();
      return;
    }
    this.g.b();
    if (!this.g.c()) {
      return;
    }
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)getItem(0);
    this.a = true;
    if (!paramView.isChecked())
    {
      c(localATroopMember);
    }
    else
    {
      b(localATroopMember);
      a(localATroopMember);
    }
    paramView.setChecked(paramView.isChecked() ^ true);
    this.a = false;
    this.g.a();
    if (!this.r.b)
    {
      paramView = this.d;
      if (paramView != null) {
        paramView.d();
      }
    }
  }
  
  private void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    int n = 0;
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((ChatHistoryTroopMemberFragment.ATroopMember)localEntry.getKey()).equals(paramATroopMember))
      {
        paramATroopMember = (AtTag)localEntry.getValue();
        break label87;
      }
      n += 1;
    }
    paramATroopMember = null;
    label87:
    localIterator = this.c.entrySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (i1 < n)
      {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      else if ((i1 != n) && (paramATroopMember != null))
      {
        AtTag localAtTag = (AtTag)localEntry.getValue();
        int i3 = localAtTag.a - paramATroopMember.b.length();
        int i2 = i3;
        if (i3 < 0) {
          i2 = 0;
        }
        localAtTag = new AtTag(i2, localAtTag.b);
        localLinkedHashMap.put(localEntry.getKey(), localAtTag);
      }
      i1 += 1;
    }
    this.c = localLinkedHashMap;
  }
  
  private void a(QuickAtListAdapter.ViewHolder paramViewHolder)
  {
    if (!this.q) {
      this.q = true;
    }
    this.g.a(paramViewHolder.f);
    paramViewHolder.f.setOnClickListener(this);
    Object localObject = this.m.ae();
    this.g.a((String)localObject);
    this.r.a(paramViewHolder.A);
    localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.l.get(0);
    if (this.c.containsKey(localObject)) {
      paramViewHolder.a.setChecked(true);
    } else {
      paramViewHolder.a.setChecked(false);
    }
    if (!this.r.b)
    {
      paramViewHolder.a.setVisibility(8);
      return;
    }
    paramViewHolder.a.setVisibility(0);
  }
  
  private void a(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramViewHolder.d != null)
    {
      ITroopRobotService localITroopRobotService = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
      int n;
      if ((localITroopRobotService != null) && (localITroopRobotService.isRobotUin(paramATroopMember.a))) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        paramViewHolder.d.setVisibility(0);
        return;
      }
      paramViewHolder.d.setVisibility(8);
    }
  }
  
  private void b(View paramView)
  {
    Object localObject = (QuickAtListAdapter.ViewHolder)paramView.getTag();
    paramView = ((QuickAtListAdapter.ViewHolder)localObject).a;
    localObject = (ChatHistoryTroopMemberFragment.ATroopMember)getItem(((QuickAtListAdapter.ViewHolder)localObject).c);
    this.a = true;
    if (!paramView.isChecked())
    {
      if (this.r.c())
      {
        this.r.b();
        this.a = false;
        return;
      }
      c((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
    }
    else
    {
      b((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
      a((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
    }
    paramView.setChecked(true ^ paramView.isChecked());
    this.a = false;
    paramView = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
    if (((this.d != null) && (paramView.isRobotUin(((ChatHistoryTroopMemberFragment.ATroopMember)localObject).a))) || ((this.d != null) && (!this.r.b))) {
      this.d.d();
    }
    if ((!TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject).S)) && (((ChatHistoryTroopMemberFragment.ATroopMember)localObject).S.equals(((ChatHistoryTroopMemberFragment.ATroopMember)localObject).n))) {
      paramView = "2";
    } else if ((!TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject).S)) && (((ChatHistoryTroopMemberFragment.ATroopMember)localObject).S.equals(((ChatHistoryTroopMemberFragment.ATroopMember)localObject).h))) {
      paramView = "3";
    } else {
      paramView = "1";
    }
    ReportController.b(this.b, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
  }
  
  private void b(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    paramATroopMember = (AtTag)this.c.get(paramATroopMember);
    Editable localEditable = this.m.Y.getEditableText();
    if (paramATroopMember != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteAtSpan: invoked.  editableText: ");
        localStringBuilder.append(localEditable);
        localStringBuilder.append(" need delete atTag: ");
        localStringBuilder.append(paramATroopMember);
        QLog.i("QuickAtListAdapter", 2, localStringBuilder.toString());
      }
      localEditable.delete(paramATroopMember.a, paramATroopMember.a + paramATroopMember.b.length());
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramViewHolder.e != null)
    {
      if (paramATroopMember.A)
      {
        paramATroopMember = BizTroopUtil.a(this.k.getResources(), Color.parseColor("#FE988A"));
        paramViewHolder.e.setBackgroundDrawable(paramATroopMember);
        paramViewHolder.e.setVisibility(0);
        return;
      }
      paramViewHolder.e.setVisibility(8);
    }
  }
  
  private void c(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (this.c.containsKey(paramATroopMember))
    {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramATroopMember });
      return;
    }
    Object localObject = AtUtil.a(paramATroopMember);
    localObject = AtTroopMemberSpan.a(this.b, this.m.f, this.m.ah.b, paramATroopMember.a, (String)localObject, AtUtil.a(paramATroopMember), this.m.Y);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    Editable localEditable = this.m.Y.getEditableText();
    int i3 = this.m.Y.getSelectionStart();
    int i4 = this.m.Y.getText().toString().lastIndexOf("@", i3);
    int n;
    int i1;
    if ((i4 != -1) && (AtUtil.c(this.m.Y) < i4))
    {
      n = i4;
      i1 = 1;
    }
    else
    {
      n = i3;
      i1 = 0;
    }
    int i2 = n;
    if (n < 0) {
      i2 = 0;
    }
    AtTag localAtTag = new AtTag(i2, (SpannableString)localObject);
    this.c.put(paramATroopMember, localAtTag);
    if (i1 != 0) {
      localEditable.delete(i4, i3);
    }
    localEditable.insert(i2, (CharSequence)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localAtTag, " editableText: ", localEditable });
    }
  }
  
  private void c(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (this.p.isTroopOwner(paramATroopMember.a))
    {
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
      paramATroopMember = TroopRankConfig.a().a(true, false);
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setText(paramATroopMember.c);
      paramATroopMember = BizTroopUtil.a(this.k.getResources(), paramATroopMember.b);
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setBackgroundDrawable(paramATroopMember);
      return;
    }
    if (this.p.isTroopAdmin(paramATroopMember.a))
    {
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
      paramATroopMember = TroopRankConfig.a().a(false, true);
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setText(paramATroopMember.c);
      paramATroopMember = BizTroopUtil.a(this.k.getResources(), paramATroopMember.b);
      QuickAtListAdapter.ViewHolder.b(paramViewHolder).setBackgroundDrawable(paramATroopMember);
      return;
    }
    QuickAtListAdapter.ViewHolder.b(paramViewHolder).setVisibility(8);
  }
  
  private void i()
  {
    this.h.a.setOnScrollListener(new QuickAtListAdapter.1(this));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.h.f;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.j);
    }
  }
  
  private void k()
  {
    String str = this.m.ah.b;
    this.p = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.h.f;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(AtPanelListener paramAtPanelListener)
  {
    this.d = paramAtPanelListener;
  }
  
  public void a(SearchTask.SearchResult paramSearchResult)
  {
    this.l = paramSearchResult.c;
    this.i = paramSearchResult.d;
    this.j = paramSearchResult.e;
    this.e = paramSearchResult.a;
    this.f = paramSearchResult.b;
    this.g.a();
    if (TextUtils.isEmpty(paramSearchResult.a))
    {
      this.s = 0;
      this.c.clear();
    }
    else
    {
      this.s = 1;
    }
    j();
    if (QLog.isColorLevel())
    {
      paramSearchResult = new StringBuilder();
      paramSearchResult.append("taa notifySearchDataChanged start  ");
      paramSearchResult.append(System.currentTimeMillis());
      QLog.e("QuickAtListAdapter", 2, paramSearchResult.toString());
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      paramSearchResult = new StringBuilder();
      paramSearchResult.append("taa notifySearchDataChanged end  ");
      paramSearchResult.append(System.currentTimeMillis());
      QLog.e("QuickAtListAdapter", 2, paramSearchResult.toString());
    }
  }
  
  public void a(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.l = paramList;
      notifyDataSetChanged();
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.s;
  }
  
  ChatHistoryTroopMemberFragment.ATroopMember b(String paramString)
  {
    Object localObject = this.l;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = this.l.size();
      int n = 0;
      while (n < i1)
      {
        localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.l.get(n);
        if ((((ChatHistoryTroopMemberFragment.ATroopMember)localObject).a != null) && (((ChatHistoryTroopMemberFragment.ATroopMember)localObject).a.equals(paramString))) {
          return localObject;
        }
        n += 1;
      }
    }
    return null;
  }
  
  public void c(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public boolean c()
  {
    List localList = this.l;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return false;
      }
      return "0".equals(((ChatHistoryTroopMemberFragment.ATroopMember)this.l.get(0)).a);
    }
    return false;
  }
  
  public int d(String paramString)
  {
    if (this.j != null)
    {
      int n = 0;
      for (;;)
      {
        String[] arrayOfString = this.j;
        if (n >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[n].equals(paramString)) {
          break label42;
        }
        n += 1;
      }
      n = -1;
      label42:
      if (n >= 0) {
        return this.i[n];
      }
    }
    return -1;
  }
  
  public void d()
  {
    AllMemberItemViewWrapper localAllMemberItemViewWrapper = this.g;
    if (localAllMemberItemViewWrapper != null) {
      localAllMemberItemViewWrapper.d();
    }
    if (this.o != null) {
      this.o.destory();
    }
  }
  
  public List<ChatHistoryTroopMemberFragment.ATroopMember> e()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.l;
    if (localList == null) {
      return localArrayList;
    }
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public QuickAtListHelper f()
  {
    return this.r;
  }
  
  public void g()
  {
    this.q = false;
  }
  
  public int getCount()
  {
    return this.l.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.l.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (c())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    int n = 1;
    if (i1 != 1) {
      n = 0;
    }
    QuickAtListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      if (n != 0) {
        paramView = LayoutInflater.from(this.k).inflate(2131629585, paramViewGroup, false);
      } else {
        paramView = LayoutInflater.from(this.k).inflate(2131629584, paramViewGroup, false);
      }
      localViewHolder = new QuickAtListAdapter.ViewHolder(paramView);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (QuickAtListAdapter.ViewHolder)paramView.getTag();
    }
    if (n != 0) {
      a(localViewHolder);
    } else {
      a(paramInt, localViewHolder);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void h()
  {
    LinkedHashMap localLinkedHashMap = this.c;
    if (localLinkedHashMap != null)
    {
      int n = localLinkedHashMap.size();
      if (n == 1) {
        ReportController.b(this.b, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
      } else if (n > 1) {
        ReportController.b(this.b, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
      this.c.clear();
    }
    this.r.b = false;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131428273)
    {
      if (n == 2131436054) {
        b(paramView);
      }
    }
    else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.QuickAtListAdapter
 * JD-Core Version:    0.7.0.1
 */