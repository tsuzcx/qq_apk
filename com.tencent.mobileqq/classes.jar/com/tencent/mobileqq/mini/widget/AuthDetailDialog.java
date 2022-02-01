package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

public class AuthDetailDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private static final String TAG = "AuthDialog";
  public static final int TYPE_BOTTOM = 1;
  public static final int TYPE_CENTER = 2;
  private AuthDetailDialog.DetailAdapter detailAdapter;
  private int dialogType = 1;
  private ImageView ivBack;
  private ListView lvDetail;
  private Activity mContext;
  private INTERFACE.StSubscribeMessage mCurSubMsg;
  private TextView tvCenterConfirm;
  private TextView tvTitle;
  
  public AuthDetailDialog(@NonNull Activity paramActivity, INTERFACE.StSubscribeMessage paramStSubscribeMessage, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramActivity, 2131755232);
    this.mContext = paramActivity;
    this.mCurSubMsg = paramStSubscribeMessage;
    setCanceledOnTouchOutside(true);
    this.dialogType = paramInt3;
    if (1 == paramInt3)
    {
      initBottomDialog(paramActivity);
      paramActivity = getWindow();
      if (paramActivity != null)
      {
        paramActivity.setGravity(80);
        if (paramInt1 > 0)
        {
          paramStSubscribeMessage = getWindow().getAttributes();
          paramStSubscribeMessage.height = paramInt1;
          paramStSubscribeMessage.width = paramInt2;
          paramActivity.setAttributes(paramStSubscribeMessage);
        }
      }
    }
    while (2 != paramInt3) {
      return;
    }
    initCenterDialog(paramActivity);
  }
  
  private void initBottomDialog(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559428, null);
    setContentView(paramContext);
    this.ivBack = ((ImageView)paramContext.findViewById(2131369316));
    this.tvTitle = ((TextView)paramContext.findViewById(2131379778));
    this.lvDetail = ((ListView)paramContext.findViewById(2131370583));
  }
  
  private void initCenterDialog(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559429, null);
    setContentView(paramContext);
    this.tvTitle = ((TextView)paramContext.findViewById(2131379778));
    this.tvCenterConfirm = ((TextView)paramContext.findViewById(2131379853));
    this.lvDetail = ((ListView)paramContext.findViewById(2131370583));
  }
  
  private void initDetailList()
  {
    if (this.lvDetail == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.mCurSubMsg.example.contents.get());
    this.detailAdapter = new AuthDetailDialog.DetailAdapter(this);
    this.detailAdapter.setData(localArrayList);
    this.lvDetail.setAdapter(this.detailAdapter);
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
      dismiss();
    }
  }
  
  public void show()
  {
    if ((this.mCurSubMsg != null) && (this.mCurSubMsg.example != null))
    {
      this.tvTitle.setText(this.mCurSubMsg.example.title.get());
      initDetailList();
      if (2 != this.dialogType) {
        break label62;
      }
      this.tvCenterConfirm.setOnClickListener(this);
    }
    for (;;)
    {
      super.show();
      return;
      label62:
      if (1 == this.dialogType) {
        this.ivBack.setOnClickListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDetailDialog
 * JD-Core Version:    0.7.0.1
 */