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

public class mbo
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private final AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private VideoChatRoomContainer jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<laf> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<mbm> jdField_a_of_type_JavaUtilList;
  private final mbr jdField_a_of_type_Mbr;
  private final mbs jdField_a_of_type_Mbs;
  private ArrayList<mbm> b = new ArrayList(10);
  private ArrayList<mbm> c = new ArrayList(10);
  
  public mbo(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306488));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Mbs = new mbs(this);
    this.jdField_a_of_type_Mbr = new mbr(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mbs);
    paramAVActivity = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.jdField_a_of_type_Mbr);
    }
  }
  
  private VideoChatRoomContainer a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null)
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306788)).inflate();
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = ((VideoChatRoomContainer)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306526));
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
    lad locallad = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallad != null) {
      locallad.a(paramChatRoomInfo, this.jdField_a_of_type_JavaUtilArrayList);
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
  
  private void a(List<laf> paramList, List<mbm> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    paramList1.clear();
    paramList = paramList.iterator();
    label31:
    laf locallaf;
    mbm localmbm;
    while (paramList.hasNext())
    {
      locallaf = (laf)paramList.next();
      if (locallaf != null)
      {
        String str2 = String.valueOf(locallaf.jdField_a_of_type_Long);
        localmbm = mbm.a();
        localmbm.b(str2);
        localmbm.a(locallaf.jdField_a_of_type_JavaLangString);
        if (!TextUtils.equals(str2, str1)) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 1;; i = 2)
    {
      localmbm.a(i);
      localmbm.c(String.format("%s|%s", new Object[] { Long.valueOf(locallaf.d), Long.valueOf(locallaf.b) }));
      paramList1.add(localmbm);
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
  
  private void c()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a();
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = a();
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(0);
    c();
    Object localObject1;
    Object localObject2;
    if (paramInt == 2)
    {
      localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { b(), 0.0F });
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.start();
    }
    for (;;)
    {
      b(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b());
      b();
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject2 != null)
      {
        localObject1 = ksn.a().a();
        localObject2 = ((lad)localObject2).a((kvq)localObject1, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { localObject1, localObject2 }));
        }
        a((ChatRoomInfo)localObject2);
      }
      lah.a("0X800A8D3");
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
    lad locallad = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallad != null) {
      locallad.b(this.jdField_a_of_type_Mbr);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mbs);
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "VideoChatRoomUIContoller-destroy");
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
    lad locallad;
    ChatRoomInfo localChatRoomInfo;
    do
    {
      do
      {
        return;
        locallad = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      } while (locallad == null);
      localChatRoomInfo = locallad.a(ksn.a().a(), true);
    } while (localChatRoomInfo == null);
    locallad.a(localChatRoomInfo, paramString, System.currentTimeMillis());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() == 0);
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiAVActivity.c());
    }
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.c() != 4) {
        break label144;
      }
      kvq localkvq = null;
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoController != null) {
        localkvq = localVideoController.a();
      }
      if ((localkvq == null) || (!localkvq.k()) || (!localkvq.r())) {
        break label144;
      }
    }
    label144:
    for (int i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k + paramInt + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(2131166395);; i = paramInt)
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
        ((AlphaAnimation)localObject).setAnimationListener(new mbp(this));
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
      localAnimatorSet.addListener(new mbq(this));
      localAnimatorSet.start();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbo
 * JD-Core Version:    0.7.0.1
 */