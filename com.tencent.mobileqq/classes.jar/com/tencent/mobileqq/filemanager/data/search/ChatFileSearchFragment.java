package com.tencent.mobileqq.filemanager.data.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;

public class ChatFileSearchFragment
  extends FileSearchFragment
{
  public String a;
  public int b;
  public int c;
  public List<Integer> d;
  Runnable e = new ChatFileSearchFragment.1(this);
  
  protected BaseMvpAdapter b()
  {
    return new ChatFileSearchFragment.ChatFileSearchAdapter(this, this.l, this.n, this.f, this.g, (QQAppInterface)this.p);
  }
  
  protected ISearchEngine c()
  {
    ChatFileManagerSearchEngine localChatFileManagerSearchEngine = new ChatFileManagerSearchEngine((QQAppInterface)this.p, this.i);
    int i = this.b;
    Bundle localBundle;
    if (i == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.a);
      localChatFileManagerSearchEngine.a(3, localBundle);
      return localChatFileManagerSearchEngine;
    }
    if (i == 2)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.a);
      localBundle.putInt("qfile_search_param_type", this.c);
      localBundle.putIntegerArrayList("qfile_search_param_others", (ArrayList)this.d);
      localChatFileManagerSearchEngine.a(4, localBundle);
    }
    return localChatFileManagerSearchEngine;
  }
  
  protected boolean cj_()
  {
    return false;
  }
  
  protected void o_(boolean paramBoolean)
  {
    if (this.b == 2)
    {
      if (paramBoolean)
      {
        this.A.setVisibility(0);
        this.C.setVisibility(8);
        this.w.setVisibility(8);
        h_(false);
        return;
      }
      this.A.setVisibility(8);
      return;
    }
    super.o_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.b == 2)
    {
      ThreadManager.executeOnFileThread(this.e);
      this.A.removeAllViewsInLayout();
      paramViewGroup = new TextView(getQBaseActivity());
      paramViewGroup.setText(HardCodeUtil.a(2131899816));
      paramViewGroup.setSingleLine(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramViewGroup.setTextSize(1, 15.0F);
      paramViewGroup.setTextColor(getResources().getColor(2131168125));
      this.A.addView(paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */