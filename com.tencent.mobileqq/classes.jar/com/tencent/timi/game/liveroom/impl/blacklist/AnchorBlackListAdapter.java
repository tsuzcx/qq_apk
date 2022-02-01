package com.tencent.timi.game.liveroom.impl.blacklist;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.widget.pull2refresh.BaseAdapter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorBlackListAdapter
  extends BaseAdapter<LimitUserInfo, AnchorBlackListAdapter.AnchorBlackViewHolder>
{
  private AnchorBlackListAdapter.OnItemBtnClickListener a;
  private int b;
  private URLDrawable.URLDrawableOptions c;
  
  public AnchorBlackListAdapter(Context paramContext, List<LimitUserInfo> paramList)
  {
    super(paramContext, paramList);
    this.b = ((int)Utils.b(48.0F, paramContext.getResources()));
    this.c = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources().getDrawable(2130852923);
    paramList = this.c;
    paramList.mLoadingDrawable = paramContext;
    paramList.mFailedDrawable = paramContext;
  }
  
  public AnchorBlackListAdapter.AnchorBlackViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AnchorBlackListAdapter.AnchorBlackViewHolder(this, paramViewGroup, 2131629403);
  }
  
  public void a(AnchorBlackListAdapter.AnchorBlackViewHolder paramAnchorBlackViewHolder, int paramInt)
  {
    Object localObject = (LimitUserInfo)getItem(paramInt);
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((LimitUserInfo)localObject).headUrl)) {
        paramAnchorBlackViewHolder.a.setImageDrawable(URLDrawable.getDrawable(((LimitUserInfo)localObject).headUrl, this.c));
      } else {
        paramAnchorBlackViewHolder.a.setImageDrawable(this.c.mLoadingDrawable);
      }
      paramAnchorBlackViewHolder.b.setText(((LimitUserInfo)localObject).nick);
      long l = ((LimitUserInfo)localObject).uid;
      paramAnchorBlackViewHolder.c.setOnClickListener(new AnchorBlackListAdapter.1(this, paramInt, l));
      localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put("qqlive_blocklist_user_id", String.valueOf(l));
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramAnchorBlackViewHolder.itemView, true, String.valueOf(l), "em_qqlive_blocklist", (Map)localObject);
      VideoReport.setElementClickPolicy(paramAnchorBlackViewHolder.itemView, ClickPolicy.REPORT_NONE);
      localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put("qqlive_moveout_user_id", String.valueOf(l));
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramAnchorBlackViewHolder.c, true, String.valueOf(l), "em_qqlive_moveout", (Map)localObject);
    }
  }
  
  public void a(AnchorBlackListAdapter.OnItemBtnClickListener paramOnItemBtnClickListener)
  {
    this.a = paramOnItemBtnClickListener;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorBlackListAdapter
 * JD-Core Version:    0.7.0.1
 */