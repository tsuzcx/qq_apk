package com.tencent.mobileqq.search.fragment.searchentry;

import android.os.Bundle;
import android.text.Editable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface ISearchEntryFragment
{
  public static final String KEY_FROM = "from";
  public static final String KEY_SOURCE = "source";
  public static final String KEY_TABTYPE = "tabType";
  public static final String TAB_ID_CONTACT = "kSearchContactTab";
  public static final String TAB_ID_DYNAMIC = "kSearchDynamicTab";
  public static final String TAB_ID_MESSAGE = "kSearchMessageTab";
  public static final String TAB_ID_READINJOY_TAB = "kSearchReadInJoyTab";
  public static final String TAB_ID_WEB_TITLE = "kSearchWebTitle";
  public static final Map<Integer, Boolean> mIsModelsReported = new HashMap();
  
  public abstract void afterTextChanged(Editable paramEditable);
  
  @NonNull
  public abstract QBaseFragment getFragment();
  
  @NonNull
  public abstract Bundle getInitData();
  
  public abstract void onSoftKeyboardClosed();
  
  public abstract void onSoftKeyboardOpened(int paramInt);
  
  public abstract void refresh();
  
  public abstract void refreshDataModels(List<SearchEntryDataModel> paramList, boolean paramBoolean);
  
  public abstract void setApp(@NonNull QQAppInterface paramQQAppInterface);
  
  public abstract void setInitData(@NonNull Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */