package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.troop.quickat.ui.AtTag;
import com.tencent.mobileqq.troop.quickat.ui.AtUtil;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.GuildAtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.util.WeakReference;

public class GuildAtListAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  QQAppInterface a;
  LinkedHashMap<IGProUserInfo, AtTag> b;
  GuildAtListHelper c;
  GuildAtPanelListener d;
  String e;
  public boolean f = false;
  private Context g;
  private final GuildAtListViewWrapper h;
  private GuildChatContext i;
  private List<IGProUserInfo> j;
  
  public GuildAtListAdapter(GuildAtListViewWrapper paramGuildAtListViewWrapper, GuildChatContext paramGuildChatContext)
  {
    super(paramGuildAtListViewWrapper.c, paramGuildAtListViewWrapper.b, paramGuildAtListViewWrapper.a, true);
    this.a = paramGuildAtListViewWrapper.b;
    this.g = paramGuildAtListViewWrapper.c;
    this.h = paramGuildAtListViewWrapper;
    this.i = paramGuildChatContext;
    this.j = new ArrayList();
    this.b = new LinkedHashMap();
    this.c = new GuildAtListHelper(this);
    e();
  }
  
  private void a(int paramInt, GuildAtListAdapter.ViewHolder paramViewHolder)
  {
    IGProUserInfo localIGProUserInfo = (IGProUserInfo)this.j.get(paramInt);
    GuildAtListAdapter.ViewHolder.a(paramViewHolder).setAvatarTinyId(localIGProUserInfo.a());
    String str = GuildNameUtil.a(localIGProUserInfo);
    paramViewHolder.b.setText(str);
    paramViewHolder.y = localIGProUserInfo.a();
    paramViewHolder.c = paramInt;
    GuildAtListAdapter.ViewHolder.b(paramViewHolder).setTag(paramViewHolder);
    GuildAtListAdapter.ViewHolder.b(paramViewHolder).setOnClickListener(this);
    a(paramViewHolder, localIGProUserInfo);
    b(paramViewHolder, localIGProUserInfo);
    c(paramViewHolder, localIGProUserInfo);
  }
  
  private void a(View paramView)
  {
    Object localObject = (GuildAtListAdapter.ViewHolder)paramView.getTag();
    paramView = ((GuildAtListAdapter.ViewHolder)localObject).a;
    localObject = (IGProUserInfo)getItem(((GuildAtListAdapter.ViewHolder)localObject).c);
    this.f = true;
    if (!paramView.isChecked())
    {
      if (this.c.c())
      {
        this.c.d();
        this.f = false;
        return;
      }
      a((IGProUserInfo)localObject);
    }
    else
    {
      b((IGProUserInfo)localObject);
      c((IGProUserInfo)localObject);
    }
    paramView.setChecked(true ^ paramView.isChecked());
    this.f = false;
    paramView = (ITroopRobotService)this.a.getRuntimeService(ITroopRobotService.class, "all");
    if (this.d == null) {
      return;
    }
    if ((paramView.isRobotUin(((IGProUserInfo)localObject).a())) || (!this.c.b)) {
      this.d.b();
    }
  }
  
  private void a(GuildAtListAdapter.ViewHolder paramViewHolder)
  {
    this.c.a(GuildAtListAdapter.ViewHolder.a(paramViewHolder));
    paramViewHolder = new WeakReference(paramViewHolder.e);
    this.h.e.a(new -..Lambda.GuildAtListAdapter.KsS_7MI0FgaQv24-rXC2xeptVEo(this, paramViewHolder));
  }
  
  private void a(GuildAtListAdapter.ViewHolder paramViewHolder, IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo.d() == 2)
    {
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setVisibility(0);
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setBackgroundResource(g());
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setText(2131890242);
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setTextColor(this.g.getColor(2131166195));
      return;
    }
    if (paramIGProUserInfo.d() == 1)
    {
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setVisibility(0);
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setBackgroundResource(h());
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setText(2131890240);
      GuildAtListAdapter.ViewHolder.c(paramViewHolder).setTextColor(this.g.getColor(2131166193));
      return;
    }
    GuildAtListAdapter.ViewHolder.c(paramViewHolder).setVisibility(8);
  }
  
  private void a(IGProUserInfo paramIGProUserInfo)
  {
    if (this.b.containsKey(paramIGProUserInfo))
    {
      QLog.d("GuildAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramIGProUserInfo });
      return;
    }
    Object localObject = GuildNameUtil.a(paramIGProUserInfo);
    localObject = GuildAtTroopMemberSpan.a(this.a, this.i.b(), this.i.O().b, paramIGProUserInfo.a(), (String)localObject, (String)localObject, this.i.Q(), 0, this.i.X());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    Editable localEditable = this.i.Q().getEditableText();
    int i1 = this.i.Q().getSelectionStart();
    int i2 = this.i.Q().getText().toString().lastIndexOf("@", i1);
    int k;
    int m;
    if ((i2 != -1) && (AtUtil.c(this.i.Q()) < i2))
    {
      k = i2;
      m = 1;
    }
    else
    {
      k = i1;
      m = 0;
    }
    int n = k;
    if (k < 0) {
      n = 0;
    }
    AtTag localAtTag = new AtTag(n, (SpannableString)localObject);
    this.b.put(paramIGProUserInfo, localAtTag);
    if (m != 0) {
      localEditable.delete(i2, i1);
    }
    localEditable.insert(n, (CharSequence)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("GuildAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localAtTag, " editableText: ", localEditable });
    }
  }
  
  private void b(View paramView)
  {
    paramView = ((GuildAtListAdapter.ViewHolder)paramView.getTag()).a;
    if ((this.c.c()) && (!paramView.isChecked()))
    {
      this.c.d();
      return;
    }
    IGProUserInfo localIGProUserInfo = (IGProUserInfo)getItem(0);
    this.f = true;
    if (!paramView.isChecked())
    {
      a(localIGProUserInfo);
    }
    else
    {
      b(localIGProUserInfo);
      c(localIGProUserInfo);
    }
    paramView.setChecked(paramView.isChecked() ^ true);
    this.f = false;
    if (!this.c.b)
    {
      paramView = this.d;
      if (paramView != null) {
        paramView.b();
      }
    }
  }
  
  private void b(GuildAtListAdapter.ViewHolder paramViewHolder, IGProUserInfo paramIGProUserInfo)
  {
    if (paramViewHolder.d != null)
    {
      if (paramIGProUserInfo == null) {
        return;
      }
      paramViewHolder = paramViewHolder.d;
      int k;
      if (paramIGProUserInfo.f() == 1) {
        k = 0;
      } else {
        k = 8;
      }
      paramViewHolder.setVisibility(k);
    }
  }
  
  private void b(IGProUserInfo paramIGProUserInfo)
  {
    paramIGProUserInfo = (AtTag)this.b.get(paramIGProUserInfo);
    Editable localEditable = this.i.Q().getEditableText();
    if (paramIGProUserInfo != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteAtSpan: invoked.  editableText: ");
        localStringBuilder.append(localEditable);
        localStringBuilder.append(" need delete atTag: ");
        localStringBuilder.append(paramIGProUserInfo);
        QLog.i("GuildAtListAdapter", 2, localStringBuilder.toString());
      }
      localEditable.delete(paramIGProUserInfo.a, paramIGProUserInfo.a + paramIGProUserInfo.b.length());
      if (QLog.isColorLevel()) {
        QLog.d("GuildAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private IGProUserInfo c(String paramString)
  {
    Object localObject = this.j;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int m = this.j.size();
      int k = 0;
      while (k < m)
      {
        localObject = (IGProUserInfo)this.j.get(k);
        if ((((IGProUserInfo)localObject).a() != null) && (((IGProUserInfo)localObject).a().equals(paramString))) {
          return localObject;
        }
        k += 1;
      }
    }
    return null;
  }
  
  private void c(GuildAtListAdapter.ViewHolder paramViewHolder, IGProUserInfo paramIGProUserInfo)
  {
    paramViewHolder.a.setChecked(this.b.containsKey(paramIGProUserInfo));
    paramViewHolder = paramViewHolder.a;
    int k;
    if (this.c.b) {
      k = 0;
    } else {
      k = 8;
    }
    paramViewHolder.setVisibility(k);
  }
  
  private void c(IGProUserInfo paramIGProUserInfo)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.b.entrySet().iterator();
    int k = 0;
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((IGProUserInfo)localEntry.getKey()).equals(paramIGProUserInfo))
      {
        paramIGProUserInfo = (AtTag)localEntry.getValue();
        break label87;
      }
      k += 1;
    }
    paramIGProUserInfo = null;
    label87:
    localIterator = this.b.entrySet().iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (m < k)
      {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      else if ((m != k) && (paramIGProUserInfo != null))
      {
        AtTag localAtTag = (AtTag)localEntry.getValue();
        int i1 = localAtTag.a - paramIGProUserInfo.b.length();
        int n = i1;
        if (i1 < 0) {
          n = 0;
        }
        localAtTag = new AtTag(n, localAtTag.b);
        localLinkedHashMap.put(localEntry.getKey(), localAtTag);
      }
      m += 1;
    }
    this.b = localLinkedHashMap;
  }
  
  private void e()
  {
    this.h.a.setOnScrollListener(new GuildAtListAdapter.1(this));
  }
  
  private boolean f()
  {
    GuildChatContext localGuildChatContext = this.i;
    return (localGuildChatContext != null) && (localGuildChatContext.X());
  }
  
  private int g()
  {
    if (f()) {
      return 2130840898;
    }
    return 2130840678;
  }
  
  private int h()
  {
    if (f()) {
      return 2130840897;
    }
    return 2130840677;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(GuildAtPanelListener paramGuildAtPanelListener)
  {
    this.d = paramGuildAtPanelListener;
  }
  
  public void a(String paramString, List<IGProUserInfo> paramList)
  {
    this.j = paramList;
    this.e = paramString;
    if (TextUtils.isEmpty(paramString)) {
      this.b.clear();
    }
    paramString = new ArrayList();
    paramList = this.j.iterator();
    while (paramList.hasNext()) {
      paramString.add(((IGProUserInfo)paramList.next()).a());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("taa notifySearchDataChanged start  ");
      paramString.append(System.currentTimeMillis());
      QLog.e("GuildAtListAdapter", 2, paramString.toString());
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("taa notifySearchDataChanged end  ");
      paramString.append(System.currentTimeMillis());
      QLog.e("GuildAtListAdapter", 2, paramString.toString());
    }
    this.h.a();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  void b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    c(paramString);
    notifyDataSetChanged();
  }
  
  public boolean b()
  {
    List localList = this.j;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return false;
      }
      return "0".equals(((IGProUserInfo)this.j.get(0)).a());
    }
    return false;
  }
  
  public void c()
  {
    LinkedHashMap localLinkedHashMap = this.b;
    if (localLinkedHashMap != null) {
      localLinkedHashMap.clear();
    }
    this.c.b = false;
  }
  
  public void d()
  {
    super.d();
  }
  
  public int getCount()
  {
    return this.j.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.j.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (b())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int m = getItemViewType(paramInt);
    int k = 1;
    if (m != 1) {
      k = 0;
    }
    if (paramView == null)
    {
      if (k != 0) {
        m = 2131625090;
      } else {
        m = 2131625089;
      }
      paramView = LayoutInflater.from(this.g).inflate(m, paramViewGroup, false);
      paramViewGroup = new GuildAtListAdapter.ViewHolder(paramView, this.a);
      if (f())
      {
        paramViewGroup.a();
        paramViewGroup.a((TextView)paramView.findViewById(2131444603));
      }
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GuildAtListAdapter.ViewHolder)paramView.getTag();
    }
    if (k != 0)
    {
      a(paramViewGroup);
      return paramView;
    }
    a(paramInt, paramViewGroup);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436054) {
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtListAdapter
 * JD-Core Version:    0.7.0.1
 */