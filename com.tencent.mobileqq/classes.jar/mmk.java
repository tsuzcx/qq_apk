import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mmk
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private final AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private VideoChatRoomContainer jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<lkq> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<mmi> jdField_a_of_type_JavaUtilList;
  private final mmn jdField_a_of_type_Mmn;
  private final mmo jdField_a_of_type_Mmo;
  private ArrayList<mmi> b = new ArrayList(10);
  private ArrayList<mmi> c = new ArrayList(10);
  
  public mmk(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131372187));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Mmo = new mmo(this);
    this.jdField_a_of_type_Mmn = new mmn(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mmo);
    paramAVActivity = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.jdField_a_of_type_Mmn);
    }
  }
  
  private VideoChatRoomContainer a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null)
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131372499)).inflate();
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = ((VideoChatRoomContainer)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131372225));
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    lko locallko = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallko != null) {
      locallko.a(paramChatRoomInfo, this.jdField_a_of_type_JavaUtilArrayList);
    }
    paramChatRoomInfo = null;
    if (this.jdField_a_of_type_JavaUtilList != this.b) {
      paramChatRoomInfo = this.b;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, paramChatRoomInfo);
      this.jdField_a_of_type_JavaUtilList = paramChatRoomInfo;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.runOnUiThread(new VideoChatRoomUIContoller.3(this));
      return;
      if (this.jdField_a_of_type_JavaUtilList != this.c) {
        paramChatRoomInfo = this.c;
      }
    }
  }
  
  private void a(List<lkq> paramList, List<mmi> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    paramList1.clear();
    paramList = paramList.iterator();
    label31:
    lkq locallkq;
    mmi localmmi;
    while (paramList.hasNext())
    {
      locallkq = (lkq)paramList.next();
      if (locallkq != null)
      {
        String str2 = String.valueOf(locallkq.jdField_a_of_type_Long);
        localmmi = mmi.a();
        localmmi.b(str2);
        localmmi.a(locallkq.jdField_a_of_type_JavaLangString);
        if (!TextUtils.equals(str2, str1)) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 1;; i = 2)
    {
      localmmi.a(i);
      localmmi.c(String.format("%s|%s", new Object[] { Long.valueOf(locallkq.d), Long.valueOf(locallkq.b) }));
      paramList1.add(localmmi);
      break label31;
      break;
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getWidth();
      int i = j;
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.measure(0, 0);
        i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getMeasuredWidth();
      }
      return i;
    }
    return 0;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a();
    }
  }
  
  private void d(int paramInt)
  {
    lga locallga = lcx.a().a();
    if (locallga.A) {
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) || (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
    return;
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = a();
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(0);
    b();
    Object localObject;
    if (paramInt == 2)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { b(), 0.0F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.start();
    }
    for (;;)
    {
      b(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b());
      a();
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null)
      {
        localObject = ((lko)localObject).a(locallga, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { locallga, localObject }));
        }
        a((ChatRoomInfo)localObject);
      }
      lks.a("0X800A8D3");
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setAlpha(1.0F);
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (a()) {
      i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return i;
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiAVActivity.c());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "showChatRoomPanel, which[" + paramInt + "]");
    }
    d(paramInt);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    lko locallko;
    ChatRoomInfo localChatRoomInfo;
    do
    {
      do
      {
        return;
        locallko = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      } while (locallko == null);
      localChatRoomInfo = locallko.a(lcx.a().a(), true);
    } while (localChatRoomInfo == null);
    locallko.a(localChatRoomInfo, paramString, System.currentTimeMillis());
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (lcx.a().a().aA = a();; lcx.a().a().aA = false)
    {
      lko locallko = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallko != null) {
        locallko.b(this.jdField_a_of_type_Mmn);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mmo);
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, "VideoChatRoomUIContoller-destroy, isQuit[" + paramBoolean + "], mCheckFirstShowChatRoomPanel[" + lcx.a().a().aA + "]");
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() == 0);
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.c() != 4) {
        break label144;
      }
      lga locallga = null;
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoController != null) {
        locallga = localVideoController.a();
      }
      if ((locallga == null) || (!locallga.k()) || (!locallga.r())) {
        break label144;
      }
    }
    label144:
    for (int i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k + paramInt + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(2131297484);; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.c()) }));
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(i);
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (a()) {
      bool = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return bool;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "hideChatRoomPanel, from[" + paramInt + "]");
    }
    Object localObject;
    if (a())
    {
      if (paramInt == 2)
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setAnimationListener(new mml(this));
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.startAnimation((Animation)localObject);
      }
    }
    else {
      return;
    }
    if (paramInt == 1)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { 0.0F, b() });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new mmm(this));
      localAnimatorSet.start();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */