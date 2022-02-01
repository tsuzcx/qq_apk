package com.tencent.mobileqq.guild.main.item;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQGuildLiveChannelBuilder$ChannelHolder
{
  private TextView a;
  private RelativeLayout b;
  private View c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private View h;
  private GuildDragTextView i;
  private View j;
  private String k = "";
  
  private IGProUserInfo a(List<IGProUserInfo> paramList, String paramString)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (TextUtils.equals(localIGProUserInfo.a(), paramString)) {
        return localIGProUserInfo;
      }
    }
    return null;
  }
  
  private void a(AppInterface paramAppInterface, int paramInt, List<IGProUserInfo> paramList)
  {
    if (TextUtils.isEmpty(this.k)) {
      return;
    }
    if (paramInt == 0)
    {
      paramList = a(paramList, this.k);
      if ((paramList != null) && (!TextUtils.isEmpty(paramList.b())))
      {
        paramList = paramList.b();
        break label54;
      }
    }
    paramList = "";
    label54:
    Object localObject = paramList;
    if (TextUtils.isEmpty(paramList)) {
      localObject = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildUserNick(this.k);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.f.setText("nickname");
      return;
    }
    this.f.setText((CharSequence)localObject);
  }
  
  private void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString1, localArrayList, true, new QQGuildLiveChannelBuilder.ChannelHolder.1(this, paramAppInterface));
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder.ChannelHolder
 * JD-Core Version:    0.7.0.1
 */