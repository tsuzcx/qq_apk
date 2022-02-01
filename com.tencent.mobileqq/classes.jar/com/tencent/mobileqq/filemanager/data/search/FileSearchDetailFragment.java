package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends BaseFragment
{
  private static FileEntitySearchResultModel g;
  FileEntitySearchResultModel a;
  String b;
  TextView c;
  ListView d;
  IFaceDecoder e;
  BaseMvpAdapter f;
  
  public static FileSearchDetailFragment a(String paramString, FileEntitySearchResultModel paramFileEntitySearchResultModel)
  {
    g = paramFileEntitySearchResultModel;
    paramFileEntitySearchResultModel = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramFileEntitySearchResultModel.setArguments(localBundle);
    return paramFileEntitySearchResultModel;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = g;
    g = null;
    this.b = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625297, paramViewGroup, false);
    this.c = ((TextView)paramLayoutInflater.findViewById(2131434940));
    this.d = ((ListView)paramLayoutInflater.findViewById(2131437272));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.e;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131889436);
    this.c.setText(String.format(paramView, new Object[] { Integer.valueOf(this.a.a.size()), this.b }));
    this.e = ((IQQAvatarService)getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
    this.f = new FileSearchDetailFragment.FileSearchAdapter(this, this.d, this.e, this.a, this.b, getBaseActivity().app);
    this.d.setAdapter(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */