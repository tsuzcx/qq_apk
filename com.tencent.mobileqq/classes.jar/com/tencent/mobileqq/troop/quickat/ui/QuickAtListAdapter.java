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
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private final AllMemberItemViewWrapper jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper;
  AtPanelListener jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener;
  private final ListViewWrapper jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper;
  private QuickAtListHelper jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<ChatHistoryTroopMemberFragment.ATroopMember, AtTag> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public QuickAtListAdapter(ListViewWrapper paramListViewWrapper, TroopChatPie paramTroopChatPie)
  {
    super(paramListViewWrapper.jdField_a_of_type_AndroidContentContext, paramListViewWrapper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListViewWrapper.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramListViewWrapper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramListViewWrapper.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper = paramListViewWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper = new AllMemberItemViewWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper = new QuickAtListHelper(this);
    d();
  }
  
  private void a(int paramInt, QuickAtListAdapter.ViewHolder paramViewHolder)
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewHolder.c.setImageBitmap(a(localATroopMember.jdField_a_of_type_JavaLangString, 2));
    Object localObject = AtUtil.b(localATroopMember);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localATroopMember.v;
    }
    localObject = new ColorNickText((CharSequence)localObject, 16).a();
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    ColorNickManager.a(paramViewHolder.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject, localATroopMember.jdField_a_of_type_Int);
    paramViewHolder.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
    paramViewHolder.jdField_a_of_type_Int = paramInt;
    QuickAtListAdapter.ViewHolder.a(paramViewHolder).setTag(paramViewHolder);
    QuickAtListAdapter.ViewHolder.a(paramViewHolder).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), paramViewHolder, localATroopMember);
    c(paramViewHolder, localATroopMember);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localATroopMember))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.jdField_a_of_type_Boolean) {
        break label210;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(paramViewHolder, localATroopMember);
      b(paramViewHolder, localATroopMember);
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label210:
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(View paramView)
  {
    paramView = ((QuickAtListAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.b();
    } while (!this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.a());
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localATroopMember);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener.a();
      return;
      b(localATroopMember);
      a(localATroopMember);
      break label79;
    }
  }
  
  private void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((ChatHistoryTroopMemberFragment.ATroopMember)((Map.Entry)localObject1).getKey()).equals(paramATroopMember)) {
        localObject1 = (AtTag)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramATroopMember = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramATroopMember.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramATroopMember.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (AtTag)localEntry.getValue();
        int m = ((AtTag)localObject2).jdField_a_of_type_Int - ((AtTag)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new AtTag(k, ((AtTag)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(QuickAtListAdapter.ViewHolder paramViewHolder)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.a(paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.a((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.a(paramViewHolder.c);
    localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.jdField_a_of_type_Boolean)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localTroopRobotManager == null) || (!localTroopRobotManager.b(paramATroopMember.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (QuickAtListAdapter.ViewHolder)paramView.getTag();
    paramView = ((QuickAtListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)getItem(((QuickAtListAdapter.ViewHolder)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localATroopMember);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener != null) && (paramView.b(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localATroopMember.v)) || (!localATroopMember.v.equals(localATroopMember.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localATroopMember);
      a(localATroopMember);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localATroopMember.v))
      {
        paramView = (View)localObject;
        if (localATroopMember.v.equals(localATroopMember.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    paramATroopMember = (AtTag)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramATroopMember);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramATroopMember != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramATroopMember);
      }
      int i = paramATroopMember.jdField_a_of_type_Int;
      int j = paramATroopMember.jdField_a_of_type_Int;
      localEditable.delete(i, paramATroopMember.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramViewHolder.b != null)
    {
      if (paramATroopMember.jdField_a_of_type_Boolean)
      {
        paramATroopMember = TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        paramViewHolder.b.setBackgroundDrawable(paramATroopMember);
        paramViewHolder.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    paramViewHolder.b.setVisibility(8);
  }
  
  private void c(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramATroopMember)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramATroopMember });
    }
    Object localObject;
    do
    {
      return;
      localObject = AtUtil.a(paramATroopMember);
      localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramATroopMember.jdField_a_of_type_JavaLangString, (String)localObject, AtUtil.a(paramATroopMember), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (AtUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      AtTag localAtTag = new AtTag(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramATroopMember, localAtTag);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localAtTag, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(QuickAtListAdapter.ViewHolder paramViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramATroopMember.jdField_a_of_type_JavaLangString))
    {
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      paramATroopMember = TroopRankConfig.a().a(true, false);
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setText(paramATroopMember.jdField_a_of_type_JavaLangString);
      paramATroopMember = TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramATroopMember.b);
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setBackgroundDrawable(paramATroopMember);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopAdmin(paramATroopMember.jdField_a_of_type_JavaLangString))
    {
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      paramATroopMember = TroopRankConfig.a().a(false, true);
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setText(paramATroopMember.jdField_a_of_type_JavaLangString);
      paramATroopMember = TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramATroopMember.b);
      QuickAtListAdapter.ViewHolder.a(paramViewHolder).setBackgroundDrawable(paramATroopMember);
      return;
    }
    QuickAtListAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new QuickAtListAdapter.1(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  ChatHistoryTroopMemberFragment.ATroopMember a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localATroopMember.jdField_a_of_type_JavaLangString != null) && (localATroopMember.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localATroopMember;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public QuickAtListHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper;
  }
  
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(AtPanelListener paramAtPanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelListener = paramAtPanelListener;
  }
  
  public void a(SearchTask.SearchResult paramSearchResult)
  {
    this.jdField_a_of_type_JavaUtilList = paramSearchResult.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramSearchResult.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramSearchResult.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = paramSearchResult.jdField_a_of_type_JavaLangString;
    this.b = paramSearchResult.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.a();
    if (TextUtils.isEmpty(paramSearchResult.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    for (;;)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public void a(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return "0".equals(((ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i != 1) {
        break label72;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListHelper.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (a())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    label37:
    QuickAtListAdapter.ViewHolder localViewHolder;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563154, paramViewGroup, false);
      localViewHolder = new QuickAtListAdapter.ViewHolder(paramView);
      paramView.setTag(localViewHolder);
      label53:
      if (i == 0) {
        break label117;
      }
      a(localViewHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563153, paramViewGroup, false);
      break label37;
      label105:
      localViewHolder = (QuickAtListAdapter.ViewHolder)paramView.getTag();
      break label53;
      label117:
      a(paramInt, localViewHolder);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.QuickAtListAdapter
 * JD-Core Version:    0.7.0.1
 */