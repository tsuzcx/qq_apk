package com.tencent.mobileqq.nearby.now.location.adapter;

import android.content.Context;
import android.text.Html;
import com.tencent.mobileqq.nearby.now.location.StringFormatUtil;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.widget.CommonAdapter;
import com.tencent.mobileqq.nearby.now.widget.CommonViewHolder;
import java.util.List;

public class SearchAdapter
  extends CommonAdapter
{
  private String a;
  
  public SearchAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
  }
  
  public void a(CommonViewHolder paramCommonViewHolder, LocationInfo paramLocationInfo)
  {
    Object localObject2 = new StringFormatUtil(paramLocationInfo.getName(), this.a);
    Object localObject1 = new StringFormatUtil(paramLocationInfo.getAddress(), this.a);
    Object localObject4 = ((StringFormatUtil)localObject2).a().a();
    localObject2 = ((StringFormatUtil)localObject1).a().a();
    for (;;)
    {
      try
      {
        localObject1 = Html.fromHtml((String)localObject4);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localObject4 = Html.fromHtml((String)localObject2);
          localObject2 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject2;
          if (localObject2 == null) {
            localObject4 = paramLocationInfo.getName();
          }
          paramCommonViewHolder.a(2131365301, (CharSequence)localObject4);
          if (localObject1 != null) {
            break label134;
          }
          paramLocationInfo = paramLocationInfo.getAddress();
          paramCommonViewHolder.a(2131365302, paramLocationInfo);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject3;
          break label117;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label117:
      localObject4 = null;
      localObject3 = localObject1;
      localObject1 = localObject4;
      continue;
      label134:
      paramLocationInfo = (LocationInfo)localObject1;
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.adapter.SearchAdapter
 * JD-Core Version:    0.7.0.1
 */