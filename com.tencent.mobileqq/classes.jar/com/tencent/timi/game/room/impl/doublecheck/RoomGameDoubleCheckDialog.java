package com.tencent.timi.game.room.impl.doublecheck;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.FullScreenDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckPlayer;

public class RoomGameDoubleCheckDialog
  extends FullScreenDialog
{
  private View a;
  private View b;
  private TextView c;
  private RecyclerView d;
  private CommonButton f;
  private TextView g;
  private RoomGameDoubleCheckPlayerAdapter h;
  private List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> i = new ArrayList();
  private long j;
  private long k;
  private Timer l;
  private TimerTask m;
  private RoomGameDoubleCheckDialog.DoubleCheckListener n;
  private long o;
  private boolean p = false;
  
  public RoomGameDoubleCheckDialog(@NonNull Context paramContext)
  {
    this(paramContext, 2131952976);
  }
  
  public RoomGameDoubleCheckDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if (!this.p)
    {
      long l1 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
      int i1 = 0;
      while (i1 < this.i.size())
      {
        YoloRoomOuterClass.YoloRoomDoubleCheckPlayer localYoloRoomDoubleCheckPlayer = (YoloRoomOuterClass.YoloRoomDoubleCheckPlayer)this.i.get(i1);
        if (localYoloRoomDoubleCheckPlayer.uid.get() == l1)
        {
          boolean bool;
          if (localYoloRoomDoubleCheckPlayer.is_check.get() == 1) {
            bool = true;
          } else {
            bool = false;
          }
          this.p = bool;
          break;
        }
        i1 += 1;
      }
      if (this.p)
      {
        this.f.setEnabled(false);
        this.f.setText("已确认");
        this.f.setTextColor(-7829368);
        this.f.setBackgroundResource(2130852931);
        this.f.setOnClickListener(null);
        return;
      }
      this.f.setEnabled(true);
      this.f.setText("确认");
      this.f.setTextColor(-1);
      this.f.setBackgroundResource(2130852933);
      this.f.setOnClickListener(new RoomGameDoubleCheckDialog.2(this));
    }
  }
  
  private void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 22)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(Color.parseColor("#4C000000"));
    }
    setContentView(LayoutInflater.from(getContext()).inflate(2131629474, null));
    this.a = findViewById(2131434040);
    this.b = findViewById(2131434036);
    this.c = ((TextView)findViewById(2131434042));
    this.d = ((RecyclerView)findViewById(2131434043));
    this.f = ((CommonButton)findViewById(2131434039));
    this.g = ((TextView)findViewById(2131434038));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.d.setLayoutManager(localLinearLayoutManager);
    this.d.setHasFixedSize(true);
    int i1 = ViewUtils.dip2px(12.0F);
    this.d.addItemDecoration(new RoomGameDoubleCheckDialog.1(this, i1));
    this.h = new RoomGameDoubleCheckPlayerAdapter(paramContext, this.i);
    this.d.setAdapter(this.h);
  }
  
  private void b()
  {
    Logger.a("RoomGameDoubleCheckDialog", "startPrepareCoundDown ");
    f();
    this.l = new Timer();
    this.m = new RoomGameDoubleCheckDialog.3(this);
    this.l.schedule(this.m, 1000L, 1000L);
    c();
  }
  
  private void b(RoomGameDoubleCheckDialog.DoubleCheckListener paramDoubleCheckListener)
  {
    this.n = paramDoubleCheckListener;
  }
  
  private void c()
  {
    long l1 = TimeUtils.a();
    int i1 = (int)((this.j - l1) / 1000L);
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("即将开始 ");
    localStringBuilder.append(i1);
    localStringBuilder.append("秒");
    localTextView.setText(localStringBuilder.toString());
    if (i1 <= 0)
    {
      f();
      if (isShowing()) {
        dismiss();
      }
    }
  }
  
  private void d()
  {
    Logger.a("RoomGameDoubleCheckDialog", "switchToFinalLaunchGameCountDown ");
    this.k = (System.currentTimeMillis() + 3000L);
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    f();
    this.l = new Timer();
    this.m = new RoomGameDoubleCheckDialog.4(this);
    this.l.schedule(this.m, 1000L, 1000L);
    e();
  }
  
  private void e()
  {
    long l1 = System.currentTimeMillis();
    int i1 = (int)((this.k - l1) / 1000L);
    this.g.setText(String.valueOf(i1));
    if (i1 <= 0)
    {
      f();
      RoomGameDoubleCheckDialog.DoubleCheckListener localDoubleCheckListener = this.n;
      if (localDoubleCheckListener != null) {
        localDoubleCheckListener.a();
      }
      if (isShowing()) {
        dismiss();
      }
    }
  }
  
  private void f()
  {
    Timer localTimer = this.l;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.l.purge();
      this.l = null;
    }
  }
  
  public void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void a(RoomGameDoubleCheckDialog.DoubleCheckListener paramDoubleCheckListener)
  {
    b(paramDoubleCheckListener);
    d();
  }
  
  public void a(List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> paramList, long paramLong)
  {
    if (paramLong > 0L) {
      this.j = paramLong;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.i.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        YoloRoomOuterClass.YoloRoomDoubleCheckPlayer localYoloRoomDoubleCheckPlayer = (YoloRoomOuterClass.YoloRoomDoubleCheckPlayer)paramList.next();
        if (localYoloRoomDoubleCheckPlayer.uid.get() != 0L) {
          this.i.add(localYoloRoomDoubleCheckPlayer);
        }
      }
    }
    paramList = this.h;
    if (paramList != null) {
      paramList.a(this.i, this.o);
    }
    a();
  }
  
  public void dismiss()
  {
    super.dismiss();
    f();
  }
  
  public void show()
  {
    super.show();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog
 * JD-Core Version:    0.7.0.1
 */