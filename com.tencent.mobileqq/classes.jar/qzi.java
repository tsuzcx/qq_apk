import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.widget.AbsListView;

public class qzi
  extends StructingMsgItemBuilder
{
  public qzi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing)
  {
    int j = 2;
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {}
    do
    {
      return;
      paramMessageForStructing = paramMessageForStructing.structingMsg.mMsgUrl;
    } while (TextUtils.isEmpty(paramMessageForStructing));
    boolean bool = paramMessageForStructing.startsWith("https://post.mp.qq.com/kan/article/");
    paramMessageForStructing = Uri.parse(paramMessageForStructing).getQueryParameter("rowkey");
    phi localphi1;
    phi localphi2;
    if (bool)
    {
      i = 1;
      localphi1 = new phi();
      localphi2 = localphi1.a("content_type", Integer.valueOf(i));
      if (!bgnt.h(BaseApplicationImpl.getContext())) {
        break label149;
      }
    }
    label149:
    for (int i = j;; i = 1)
    {
      localphi2.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", pha.h());
      if (!TextUtils.isEmpty(paramMessageForStructing)) {
        localphi1.a("rowkey", paramMessageForStructing);
      }
      oat.a(paramString, localphi1.a());
      return;
      i = 2;
      break;
    }
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    a("0X800AD69", paramMessageForStructing);
  }
  
  private void e(View paramView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { -30.0F, 0.0F });
    localValueAnimator.setInterpolator(new qzk(this));
    localValueAnimator.setDuration(3000L);
    localValueAnimator.addUpdateListener(new qzl(this, paramView));
    localValueAnimator.start();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    if (paramView == null) {}
    for (int i = 1;; i = 0)
    {
      paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
      if (i != 0)
      {
        paramView.setTag(2131369971, "RIJRedPacketStruttingMsgItemBuilder");
        paramafzq = (qzm)paramView.getTag();
        PressEffectImageView localPressEffectImageView = new PressEffectImageView(this.a);
        localPressEffectImageView.setId(2131375974);
        localPressEffectImageView.setImageResource(2130849439);
        localPressEffectImageView.setPivotX(zby.b(this.a, 10.0F));
        localPressEffectImageView.setPivotY(0.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(zby.b(this.a, 20.0F), zby.b(this.a, 23.5F));
        localLayoutParams.addRule(7, 2131364379);
        localLayoutParams.addRule(6, 2131364379);
        localLayoutParams.rightMargin = zby.b(this.a, 20.0F);
        localLayoutParams.topMargin = zby.b(this.a, 17.0F);
        ((ViewGroup)paramView).addView(localPressEffectImageView, localLayoutParams);
        paramafzq.a = localPressEffectImageView;
        e(localPressEffectImageView);
      }
      paramViewGroup = (AbsListView)paramViewGroup;
      paramChatMessage = new qzj(this, paramViewGroup, paramChatMessage);
      if (paramViewGroup.getTag(2131369973) == null)
      {
        paramViewGroup.setTag(2131369973, paramChatMessage);
        paramViewGroup.addOnScrollListener(paramChatMessage);
      }
      return paramView;
    }
  }
  
  protected qzm a()
  {
    return new qzm(this, null);
  }
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    a("0X800AD6A", paramMessageForStructing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzi
 * JD-Core Version:    0.7.0.1
 */