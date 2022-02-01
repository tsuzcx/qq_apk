package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.IViewPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class VoiceAdapter
  extends RecyclerView.Adapter<VoiceAdapter.VoiceViewHolder>
  implements View.OnClickListener
{
  private Context a;
  private CommandInfo b;
  private List<VoiceItemInfo> c;
  private IViewPresenter d;
  private AppInterface e;
  
  public VoiceAdapter(Context paramContext)
  {
    this.a = paramContext;
    paramContext = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramContext instanceof AppInterface)) {
      this.e = ((AppInterface)paramContext);
    }
  }
  
  private VoiceItemInfo a(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (VoiceItemInfo)this.c.get(paramInt);
    }
    return null;
  }
  
  public VoiceAdapter.VoiceViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("onCreateViewHolder viewType is error: ");
        paramViewGroup.append(paramInt);
        QLog.d("VoiceAdapter", 2, paramViewGroup.toString());
      }
      break;
    case 9: 
      paramViewGroup = VoiceViewUtils.d(this.a, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 8: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.f(this.a));
    case 7: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.e(this.a));
    case 6: 
      paramViewGroup = VoiceViewUtils.c(this.a, paramViewGroup);
      paramViewGroup.findViewById(2131430719).setOnClickListener(this);
      paramViewGroup.findViewById(2131430716).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 5: 
      paramViewGroup = VoiceViewUtils.b(this.a, paramViewGroup);
      paramViewGroup.findViewById(2131449976).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 4: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.d(this.a));
    case 3: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.c(this.a));
    case 2: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.b(this.a));
    case 1: 
      paramViewGroup = VoiceViewUtils.a(this.a, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 0: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.a(this.a));
    }
    return new VoiceAdapter.VoiceViewHolder(this, 0, VoiceViewUtils.a(this.a));
  }
  
  public List<VoiceItemInfo> a()
  {
    return this.c;
  }
  
  public void a(IViewPresenter paramIViewPresenter)
  {
    this.d = paramIViewPresenter;
  }
  
  public void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData list is empty");
      }
      return;
    }
    if ((this.c != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData do not need refresh");
      }
      return;
    }
    this.b = paramCommandInfo;
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull VoiceAdapter.VoiceViewHolder paramVoiceViewHolder, int paramInt)
  {
    Object localObject2 = a(paramInt);
    if (localObject2 != null)
    {
      paramInt = paramVoiceViewHolder.a;
      if (paramInt != 0)
      {
        Object localObject1;
        Object localObject3;
        switch (paramInt)
        {
        default: 
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onBindViewHolder viewType is error: ");
          ((StringBuilder)localObject1).append(paramVoiceViewHolder.a);
          QLog.d("VoiceAdapter", 2, ((StringBuilder)localObject1).toString());
          return;
        case 9: 
          if ((paramVoiceViewHolder.b == null) || (((VoiceItemInfo)localObject2).d == null) || (this.e == null)) {
            break;
          }
          localObject3 = (ImageView)paramVoiceViewHolder.b.findViewById(2131433784);
          TextView localTextView1 = (TextView)paramVoiceViewHolder.b.findViewById(2131433802);
          TextView localTextView2 = (TextView)paramVoiceViewHolder.b.findViewById(2131433785);
          localObject1 = null;
          if (((VoiceItemInfo)localObject2).d.c == 0) {
            localObject1 = FaceDrawable.getFaceDrawable(this.e, 1, ((VoiceItemInfo)localObject2).d.a);
          } else if (1 == ((VoiceItemInfo)localObject2).d.c) {
            localObject1 = FaceDrawable.getFaceDrawable(this.e, 4, ((VoiceItemInfo)localObject2).d.a);
          }
          if (localObject1 == null) {
            ((ImageView)localObject3).setImageBitmap(BaseImageUtil.k());
          } else {
            ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
          }
          localTextView1.setText(((VoiceItemInfo)localObject2).d.b);
          localTextView2.setText(((VoiceItemInfo)localObject2).d.f);
          paramVoiceViewHolder.b.setTag(((VoiceItemInfo)localObject2).d);
          return;
        case 8: 
          if (!(paramVoiceViewHolder.b instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.b).setText(((VoiceItemInfo)localObject2).b);
          return;
        case 7: 
          if (((VoiceItemInfo)localObject2).a != 7) {
            break;
          }
          paramVoiceViewHolder.b.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(((VoiceItemInfo)localObject2).c)));
          return;
        case 6: 
          if (paramVoiceViewHolder.b == null) {
            break;
          }
          localObject3 = (TextView)paramVoiceViewHolder.b.findViewById(2131430716);
          localObject2 = (TextView)paramVoiceViewHolder.b.findViewById(2131430719);
          if (b() == 5)
          {
            paramVoiceViewHolder = this.a.getString(2131893063);
            localObject1 = this.a.getString(2131917971);
          }
          else if (b() == 6)
          {
            paramVoiceViewHolder = this.a.getString(2131917969);
            localObject1 = this.a.getString(2131917970);
          }
          else
          {
            paramVoiceViewHolder = this.a.getString(2131917945);
            localObject1 = this.a.getString(2131917947);
          }
          if (localObject3 != null)
          {
            ((TextView)localObject3).setText(paramVoiceViewHolder);
            ((TextView)localObject3).setVisibility(0);
          }
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setVisibility(0);
          }
          paramVoiceViewHolder = this.b;
          if ((paramVoiceViewHolder != null) && (paramVoiceViewHolder.f != null) && (this.b.f.g))
          {
            if (localObject3 != null) {
              ((TextView)localObject3).setText(this.a.getString(2131917944));
            }
            if (localObject2 != null) {
              ((TextView)localObject2).setText(this.a.getString(2131917946));
            }
          }
          paramVoiceViewHolder = this.b;
          if ((paramVoiceViewHolder == null) || (paramVoiceViewHolder.d == null) || (this.b.d.size() != 1)) {
            break;
          }
          paramVoiceViewHolder = (FriendItemInfo)this.b.d.get(0);
          if ((paramVoiceViewHolder.d) || (paramVoiceViewHolder.h < FriendSortHelper.a()) || (localObject2 == null)) {
            break;
          }
          ((TextView)localObject2).setVisibility(8);
          return;
        case 5: 
          if (paramVoiceViewHolder.b == null) {
            break;
          }
          paramVoiceViewHolder = (TextView)paramVoiceViewHolder.b.findViewById(2131449976);
          if (paramVoiceViewHolder == null) {
            break;
          }
          paramVoiceViewHolder.setText(((VoiceItemInfo)localObject2).b);
          return;
        case 4: 
          if (!(paramVoiceViewHolder.b instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.b).setText(((VoiceItemInfo)localObject2).b);
          return;
        case 3: 
          if (!(paramVoiceViewHolder.b instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.b).setText(((VoiceItemInfo)localObject2).b);
          return;
        case 2: 
          if (!(paramVoiceViewHolder.b instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.b).setText(((VoiceItemInfo)localObject2).b);
          return;
        }
      }
      else if ((paramVoiceViewHolder.b instanceof TextView))
      {
        ((TextView)paramVoiceViewHolder.b).setText(((VoiceItemInfo)localObject2).b);
      }
    }
  }
  
  public int b()
  {
    CommandInfo localCommandInfo = this.b;
    if (localCommandInfo != null) {
      return localCommandInfo.a;
    }
    return -1;
  }
  
  public CommandInfo c()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = (VoiceItemInfo)this.c.get(paramInt);
      if (localObject != null) {
        return ((VoiceItemInfo)localObject).a;
      }
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131449810)
    {
      localObject = this.d;
      if (localObject != null) {
        ((IViewPresenter)localObject).a();
      }
    }
    else if (i == 2131430719)
    {
      localObject = this.d;
      if (localObject != null) {
        ((IViewPresenter)localObject).a(true);
      }
    }
    else if (i == 2131430716)
    {
      localObject = this.d;
      if (localObject != null) {
        ((IViewPresenter)localObject).a(false);
      }
    }
    else if (i == 2131449976)
    {
      localObject = this.d;
      if (localObject != null)
      {
        CommandInfo localCommandInfo = this.b;
        if (localCommandInfo != null) {
          ((IViewPresenter)localObject).a(localCommandInfo.a);
        }
      }
    }
    else if ((i == 2131433788) && (this.d != null) && ((paramView.getTag() instanceof FriendItemInfo)))
    {
      localObject = (FriendItemInfo)paramView.getTag();
      this.d.a((FriendItemInfo)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceAdapter
 * JD-Core Version:    0.7.0.1
 */