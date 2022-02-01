package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardConfigUtil;", "", "()V", "TAG", "", "decodedHashJumpUrl", "showHashBtn", "", "showMessageBoard", "getDecodedHashJumpUrl", "initConfig", "", "isShowHashBtn", "isShowMessageBoard", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabMessageBoardConfigUtil
{
  public static final RIJXTabMessageBoardConfigUtil a;
  private static boolean b;
  private static boolean c;
  private static String d;
  
  static
  {
    RIJXTabMessageBoardConfigUtil localRIJXTabMessageBoardConfigUtil = new RIJXTabMessageBoardConfigUtil();
    a = localRIJXTabMessageBoardConfigUtil;
    d = "";
    localRIJXTabMessageBoardConfigUtil.d();
  }
  
  public final boolean a()
  {
    return b;
  }
  
  public final boolean b()
  {
    return c;
  }
  
  @NotNull
  public final String c()
  {
    return d;
  }
  
  public final void d()
  {
    Object localObject1 = Aladdin.getConfig(440);
    boolean bool2 = false;
    int i;
    if (localObject1 != null) {
      i = ((AladdinConfig)localObject1).getIntegerFromString("fourTab_button_hashTag", 0);
    } else {
      i = 0;
    }
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    b = bool1;
    if (b)
    {
      if (localObject1 != null) {
        i = ((AladdinConfig)localObject1).getIntegerFromString("hash_button_type", 0);
      } else {
        i = 0;
      }
      if (i == 1)
      {
        bool1 = true;
        break label82;
      }
    }
    boolean bool1 = false;
    label82:
    c = bool1;
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = ((AladdinConfig)localObject1).getString("hashTag_jump_url", "");
        if (localObject1 == null) {
          break label341;
        }
        localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "URLDecoder.decode(\n     …rl\", \"\") ?: \"\"), \"UTF-8\")");
        d = (String)localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject2;
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[init] e = ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.e("RIJXTabMessageBoardConfigUtil", 1, ((StringBuilder)localObject1).toString());
      if (c)
      {
        if ((QFlutterInstaller.b(RIJQQAppInterfaceUtil.b())) && (QFlutterInstaller.a(RIJQQAppInterfaceUtil.b()))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        b = bool1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[init] isFlutterReady = ");
        ((StringBuilder)localObject1).append(b);
        QLog.i("RIJXTabMessageBoardConfigUtil", 1, ((StringBuilder)localObject1).toString());
        bool1 = bool2;
        if (c)
        {
          bool1 = bool2;
          if (b) {
            bool1 = true;
          }
        }
        c = bool1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[initConfig] showHashBtn = ");
      ((StringBuilder)localObject1).append(b);
      ((StringBuilder)localObject1).append(", showMessageBoard = ");
      ((StringBuilder)localObject1).append(c);
      ((StringBuilder)localObject1).append(", decodedHashJumpUrl = ");
      ((StringBuilder)localObject1).append(d);
      QLog.i("RIJXTabMessageBoardConfigUtil", 1, ((StringBuilder)localObject1).toString());
      return;
      label341:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardConfigUtil
 * JD-Core Version:    0.7.0.1
 */