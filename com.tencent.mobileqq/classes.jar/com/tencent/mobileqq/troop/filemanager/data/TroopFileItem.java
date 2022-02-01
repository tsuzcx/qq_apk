package com.tencent.mobileqq.troop.filemanager.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Map;

public class TroopFileItem
{
  protected QQAppInterface a;
  protected Context b;
  protected long c;
  protected int d = 0;
  protected View e;
  protected AsyncImageView f;
  protected EllipsizingTextView g;
  protected TextView h;
  protected ImageView i;
  protected CircleFileStateView j;
  protected CheckBox k;
  protected View l;
  protected TroopFileInfo m;
  protected TroopFileItemOperation n;
  protected View.OnClickListener o;
  protected View.OnLongClickListener p;
  protected View.OnClickListener q;
  protected QQFileManagerUtil.TipsClickedInterface r;
  private TroopFileItem.OnItemSelectedListener s;
  private boolean t = false;
  private boolean u = false;
  private boolean v;
  private boolean w;
  private String x;
  private SparseIntArray y;
  
  public TroopFileItem(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramLong;
    this.d = paramInt2;
    this.l = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.e = this.l.findViewById(2131448124);
    this.e.setTag(this);
    this.f = ((AsyncImageView)this.l.findViewById(2131448129));
    this.g = ((EllipsizingTextView)this.l.findViewById(2131448130));
    this.h = ((TextView)this.l.findViewById(2131448127));
    this.i = ((ImageView)this.l.findViewById(2131448128));
    this.j = ((CircleFileStateView)this.l.findViewById(2131448125));
    this.k = ((CheckBox)this.l.findViewById(2131433116));
    this.n = new TroopFileItemOperation(this.c, this.a, (Activity)this.b);
    a();
    this.x = "";
    b();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l1) {
      return paramContext.getString(2131895110);
    }
    paramLong = (paramLong - l1) / 86400000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong + 1L);
    localStringBuilder.append(paramContext.getString(2131895083));
    return localStringBuilder.toString();
  }
  
  private final void a(boolean paramBoolean, int paramInt)
  {
    CircleFileStateView localCircleFileStateView = this.j;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localCircleFileStateView.setVisibility(i1);
    if (paramInt == -1)
    {
      this.j.setVisibility(8);
      return;
    }
    this.j.setVisibility(0);
    this.j.setState(paramInt);
    if (paramInt == 1) {
      this.j.setContentDescription(HardCodeUtil.a(2131912607));
    } else if (paramInt == 3) {
      this.j.setContentDescription(HardCodeUtil.a(2131912587));
    } else if (paramInt == 2) {
      this.j.setContentDescription(HardCodeUtil.a(2131912588));
    } else {
      this.j.setContentDescription("");
    }
    long l4 = this.m.r;
    long l2 = this.m.e;
    long l1 = l4;
    long l3 = l2;
    if (l4 > l2)
    {
      l1 = l2;
      l3 = l2;
    }
    while (l3 > 2147483647L)
    {
      l3 >>= 1;
      l1 >>= 1;
    }
    double d1 = l1;
    Double.isNaN(d1);
    double d2 = l3;
    Double.isNaN(d2);
    paramInt = (int)(d1 * 100.0D / d2);
    this.j.setProgress(paramInt);
  }
  
  private void b()
  {
    this.y = new SparseIntArray();
    this.y.put(0, 1);
    this.y.put(1, 1);
    this.y.put(2, 3);
    this.y.put(3, 3);
    this.y.put(6, -1);
    this.y.put(8, 1);
    this.y.put(9, 2);
    this.y.put(10, 2);
    this.y.put(11, -1);
    this.y.put(7, -1);
  }
  
  protected TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if (paramView != null)
    {
      if (!(paramView instanceof TroopFileInfo)) {
        return null;
      }
      return (TroopFileInfo)paramView;
    }
    return null;
  }
  
  protected void a()
  {
    this.o = new TroopFileItem.1(this);
    this.p = new TroopFileItem.2(this);
    this.q = new TroopFileItem.3(this);
    this.r = new TroopFileItem.4(this);
    this.e.setOnClickListener(this.o);
    this.e.setOnLongClickListener(this.p);
    this.j.setOnClickListener(this.q);
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1 = this.m;
    if (localObject1 == null) {
      return;
    }
    this.x = "";
    this.j.setTag(localObject1);
    this.h.setTag(this.m);
    paramContext.getResources();
    this.v = this.m.B;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject3 = this.m.d;
    if (!this.v)
    {
      if (!paramBoolean)
      {
        localObject1 = this.m;
        if ((localObject1 != null) && (((TroopFileInfo)localObject1).w == null)) {
          paramQQAppInterface.a(this.m.b, 128);
        }
      }
      if (FileUtils.fileExistsAndNotEmpty(this.m.w))
      {
        i1 = FileManagerUtil.c(this.m.d);
        FileManagerUtil.a(this.f, this.m.w, i1);
      }
      else
      {
        i1 = FileManagerUtil.i(this.m.d);
        this.f.setDefaultImage(i1);
      }
      this.f.setContentDescription(HardCodeUtil.a(2131912614));
    }
    else
    {
      this.f.setDefaultImage(2130845683);
      this.f.setContentDescription(HardCodeUtil.a(2131912630));
    }
    Object localObject2;
    if (!this.v)
    {
      localObject2 = this.m.a();
      paramQQAppInterface = this.m.c();
      localObject1 = this.m.E;
      this.g.setText((CharSequence)localObject3);
      this.g.setMaxLines(2);
      this.g.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }
    else
    {
      this.g.setText((CharSequence)localObject3);
      this.g.setMaxLines(2);
      this.g.setEllipsize(TextUtils.TruncateAt.END);
      if (this.m.D.size() > 0)
      {
        paramQQAppInterface = String.format(this.b.getString(2131895149), new Object[] { Integer.valueOf(this.m.D.size()) });
      }
      else
      {
        if (this.m.C < 0) {
          this.m.C = 0;
        }
        paramQQAppInterface = String.format(this.b.getString(2131895112), new Object[] { Integer.valueOf(this.m.C) });
      }
      localObject1 = this.m.F;
      localObject2 = this.h;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.b.getString(2131889334));
      ((StringBuilder)localObject3).append(paramQQAppInterface);
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localObject3 = "";
      paramQQAppInterface = (QQAppInterface)localObject3;
      localObject2 = paramQQAppInterface;
      localObject1 = paramQQAppInterface;
      paramQQAppInterface = (QQAppInterface)localObject3;
    }
    if (this.w) {
      paramQQAppInterface = "";
    }
    Object localObject4 = null;
    localObject3 = localObject4;
    if (this.m.j != 0)
    {
      localObject3 = localObject4;
      if (this.m.f != 102) {
        localObject3 = a(paramContext, this.m.j);
      }
    }
    if (TroopFileInfo.FileStatus.a(this.m.p)) {}
    while (this.w)
    {
      i1 = 0;
      break;
    }
    int i1 = 1;
    if ((this.m.p != 0) && (this.m.p != 1) && (this.m.p != 2) && (this.m.p != 8) && (this.m.p != 9)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    if ((this.m.p != 11) && (this.m.p != 6)) {
      c(false);
    } else if (FileUtil.b(this.m.t)) {
      c(true);
    } else {
      c(false);
    }
    a(paramBoolean, this.y.get(this.m.p, -1));
    if (i1 == 0) {
      paramQQAppInterface = "";
    }
    if (this.t)
    {
      this.j.setVisibility(8);
      if (this.m.B)
      {
        this.k.setVisibility(4);
      }
      else
      {
        this.k.setVisibility(0);
        this.k.setChecked(this.u);
      }
    }
    else
    {
      this.k.setVisibility(8);
    }
    QFileUtils.a(this.b, this.h, (String)localObject1, paramQQAppInterface, (String)localObject2, (String)localObject3, this.x, true, this.r);
  }
  
  public void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    TroopFileInfo localTroopFileInfo = this.m;
    if (localTroopFileInfo == null) {
      return;
    }
    if (!localTroopFileInfo.B)
    {
      localTroopFileInfo = this.m;
      if ((localTroopFileInfo != null) && (localTroopFileInfo.w == null)) {
        TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.m.b, 128);
      }
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getId() != 2131448125) {
      paramView = paramView.findViewById(2131448125);
    }
    if ((paramView != null) && ((paramView instanceof CircleFileStateView))) {
      ((CircleFileStateView)paramView).setState(paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopFileInfo localTroopFileInfo = this.m;
    if (localTroopFileInfo != null) {
      TextUtils.isEmpty(localTroopFileInfo.b(paramQQAppInterface, paramLong));
    }
  }
  
  public void a(TroopFileItem.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.s = paramOnItemSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void b(long paramLong, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = this.m;
    if (paramQQAppInterface == null) {
      return;
    }
    if (!paramQQAppInterface.B)
    {
      if (FileUtils.fileExistsAndNotEmpty(this.m.w))
      {
        i1 = FileManagerUtil.c(this.m.d);
        FileManagerUtil.a(this.f, this.m.w, i1);
        return;
      }
      int i1 = FileManagerUtil.i(this.m.d);
      this.f.setDefaultImage(i1);
    }
  }
  
  protected void b(View paramView)
  {
    TroopFileInfo localTroopFileInfo = a(paramView.findViewById(2131448125));
    if (localTroopFileInfo == null) {
      return;
    }
    if (this.t)
    {
      if (!localTroopFileInfo.B) {
        if (this.u)
        {
          paramView = this.s;
          if (paramView != null) {
            paramView.a(false, localTroopFileInfo);
          }
        }
        else
        {
          paramView = this.s;
          if (paramView != null) {
            paramView.a(true, localTroopFileInfo);
          }
        }
      }
    }
    else
    {
      if (!localTroopFileInfo.B)
      {
        switch (localTroopFileInfo.p)
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 13: 
          this.n.h(localTroopFileInfo);
          return;
        case 12: 
          this.n.a(localTroopFileInfo, this.b.getString(2131895543), this.b.getString(2131895544));
          return;
        }
        TroopFileStatusInfo localTroopFileStatusInfo = this.n.f(localTroopFileInfo);
        int i1 = FileManagerUtil.c(localTroopFileStatusInfo.t);
        if ((i1 != 0) && (i1 != 2))
        {
          QFileUtils.a(this.a, this.b, null, localTroopFileStatusInfo, String.valueOf(localTroopFileInfo.g), localTroopFileInfo.j, this.d, false);
          return;
        }
        i1 = this.n.g(localTroopFileInfo);
        paramView = QFileUtils.a(paramView.findViewById(2131448129), localTroopFileInfo.d);
        QFileUtils.a(this.a, this.b, null, null, this.c, localTroopFileStatusInfo, String.valueOf(localTroopFileInfo.g), localTroopFileInfo.j, i1, this.d, paramView, false, false);
        return;
      }
      paramView = new Intent();
      paramView.putExtra(TeamWorkConstants.e, this.c);
      paramView.putExtra("folderPath", localTroopFileInfo.c);
      paramView.putExtra("folderName", localTroopFileInfo.d);
      paramView.putExtra("param_from", 2000);
      TroopFileProxyActivity.a((Activity)this.b, paramView, this.a.getCurrentAccountUin());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(0);
      this.x = this.b.getString(2131889335);
      return;
    }
    this.i.setVisibility(4);
    this.x = "";
  }
  
  protected boolean c(View paramView)
  {
    return false;
  }
  
  protected void d(View paramView)
  {
    TroopFileInfo localTroopFileInfo = a(paramView);
    if (localTroopFileInfo == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a, this.c);
    switch (localTroopFileInfo.p)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 13: 
      this.n.h(localTroopFileInfo);
      a(paramView, 1);
      return;
    case 12: 
      this.n.a(localTroopFileInfo, this.b.getString(2131895543), this.b.getString(2131895544));
      a(paramView, 2);
      return;
    case 10: 
      this.n.d(localTroopFileInfo);
      a(paramView, 2);
      return;
    case 9: 
      this.n.b(localTroopFileInfo.b);
      return;
    case 8: 
      localTroopFileTransferManager.e(localTroopFileInfo.b);
      a(paramView, 2);
      return;
    case 7: 
      this.n.a(localTroopFileInfo.c, localTroopFileInfo.d, localTroopFileInfo.e, localTroopFileInfo.f);
      a(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.n.f(localTroopFileInfo);
      int i1 = this.n.g(localTroopFileInfo);
      QFileUtils.a(this.a, this.b, null, null, this.c, paramView, String.valueOf(localTroopFileInfo.g), localTroopFileInfo.j, i1, this.d, null, false, false);
      return;
    case 3: 
      this.n.c(localTroopFileInfo);
      return;
    case 2: 
      this.n.a(localTroopFileInfo.b);
      return;
    }
    localTroopFileTransferManager.b(localTroopFileInfo.b);
    a(paramView, 3);
  }
  
  protected void e(View paramView)
  {
    paramView = a((TextView)paramView.findViewById(2131448127));
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.b, this.c);
    localIntent.putExtra("filter_member_name", paramView.c());
    localIntent.putExtra("filter_uin", paramView.g);
    localIntent.putExtra("folderPath", "/");
    localIntent.putExtra("param_from", 4000);
    TroopFileProxyActivity.a((Activity)this.b, localIntent, this.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileItem
 * JD-Core Version:    0.7.0.1
 */