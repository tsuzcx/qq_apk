package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class MessageSearchDetailFragment
  extends BaseFragment
{
  private static FullMessageSearchResult.SearchResultItem a;
  private TextView b;
  private ListView c;
  private String d;
  private FullMessageSearchResult.SearchResultItem e;
  private BaseMvpMessageAdapter f;
  private IFaceDecoder g;
  
  public static MessageSearchDetailFragment a(String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    a = paramSearchResultItem;
    paramSearchResultItem = new MessageSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramSearchResultItem.setArguments(localBundle);
    return paramSearchResultItem;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = a;
    a = null;
    this.d = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625297, paramViewGroup, false);
    this.b = ((TextView)paramLayoutInflater.findViewById(2131434940));
    this.c = ((ListView)paramLayoutInflater.findViewById(2131437272));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.g;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.e;
    int i;
    if ((paramView != null) && (paramView.secondPageMessageUniseq != null)) {
      i = this.e.secondPageMessageUniseq.size();
    } else {
      i = 0;
    }
    this.b.setText(getString(2131916108, new Object[] { Integer.valueOf(i), this.d }));
    this.g = ((IQQAvatarService)getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
    this.f = new MessageSearchDetailFragment.1(this, this.c, this.g, this.e, this.d, getBaseActivity().app);
    this.c.setAdapter(this.f);
    this.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */