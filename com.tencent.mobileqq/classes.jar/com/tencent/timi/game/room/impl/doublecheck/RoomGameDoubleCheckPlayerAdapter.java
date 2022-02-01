package com.tencent.timi.game.room.impl.doublecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public class RoomGameDoubleCheckPlayerAdapter
  extends RecyclerView.Adapter<RoomGameDoubleCheckPlayerAdapter.PlayerHolder>
{
  protected List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> a = new ArrayList();
  private Context b;
  private LayoutInflater c;
  private long d;
  
  public RoomGameDoubleCheckPlayerAdapter(Context paramContext, List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> paramList)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
  }
  
  @NonNull
  public RoomGameDoubleCheckPlayerAdapter.PlayerHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new RoomGameDoubleCheckPlayerAdapter.PlayerHolder(this.c.inflate(2131629475, null, false));
  }
  
  public void a(@NonNull RoomGameDoubleCheckPlayerAdapter.PlayerHolder paramPlayerHolder, int paramInt)
  {
    YoloRoomOuterClass.YoloRoomDoubleCheckPlayer localYoloRoomDoubleCheckPlayer = (YoloRoomOuterClass.YoloRoomDoubleCheckPlayer)this.a.get(paramInt);
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.d).b(localYoloRoomDoubleCheckPlayer.uid.get());
    if (localObject != null) {
      localObject = ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject).user_id;
    } else {
      localObject = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(localYoloRoomDoubleCheckPlayer.uid.get());
    }
    paramPlayerHolder.a.setUserId((CommonOuterClass.QQUserId)localObject);
    int j = localYoloRoomDoubleCheckPlayer.is_check.get();
    int i = 0;
    paramInt = 1;
    if (j != 1) {
      paramInt = 0;
    }
    localObject = paramPlayerHolder.a;
    float f;
    if (paramInt != 0) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    ((AvatarRoundImageView)localObject).setAlpha(f);
    paramPlayerHolder = paramPlayerHolder.b;
    if (paramInt != 0) {
      paramInt = i;
    } else {
      paramInt = 4;
    }
    paramPlayerHolder.setVisibility(paramInt);
  }
  
  public void a(List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> paramList, long paramLong)
  {
    this.d = paramLong;
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */