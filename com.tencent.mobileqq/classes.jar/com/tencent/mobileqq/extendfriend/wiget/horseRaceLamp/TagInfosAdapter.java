package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class TagInfosAdapter
{
  private ArrayList<TagInfo> a = new ArrayList();
  
  public static String a(String paramString, Context paramContext)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      paramString.replaceAll("\n|\r\n", " ");
      str = paramString;
    } while (paramString.length() <= 20);
    paramString = paramString.substring(0, 19);
    return paramString + paramContext.getResources().getString(2131698757);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a(Context paramContext, TagInfo paramTagInfo, ViewGroup paramViewGroup)
  {
    if (paramTagInfo == null) {}
    int i;
    do
    {
      return null;
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131561243, null);
      if (paramViewGroup == null) {
        break;
      }
      i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297318);
      if (paramTagInfo.a == null) {
        paramTagInfo.a = "";
      }
      paramContext = a(paramTagInfo.a, paramContext);
    } while (paramContext == null);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131379091);
    localTextView.setText(paramTagInfo.a);
    localTextView.setTextSize(0, i);
    localTextView.setText(paramContext);
    localTextView.setSingleLine(true);
    paramContext = (ImageView)paramViewGroup.findViewById(2131368603);
    if (paramTagInfo.a()) {
      paramContext.setBackgroundResource(2130845246);
    }
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-2, BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297315)));
    return paramViewGroup;
  }
  
  public TagInfo a(int paramInt)
  {
    return (TagInfo)this.a.get(paramInt);
  }
  
  public void a(ArrayList<TagInfo> paramArrayList)
  {
    int i = 0;
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
    for (;;)
    {
      return;
      this.a.clear();
      if (paramArrayList.size() < 16)
      {
        i = j;
        while (i < 16)
        {
          j = paramArrayList.size();
          this.a.add(paramArrayList.get(i % j));
          i += 1;
        }
      }
      else
      {
        while (i < paramArrayList.size())
        {
          this.a.add(paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.TagInfosAdapter
 * JD-Core Version:    0.7.0.1
 */