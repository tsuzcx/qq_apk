import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.Companion.instance.2;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.getClipWording.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/RIJWatchWordShareManager;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "()V", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "privateTopicWatchWord", "getPrivateTopicWatchWord", "()Ljava/lang/String;", "privateVideoWatchWord", "getPrivateVideoWatchWord", "publicTopicWatchWord", "getPublicTopicWatchWord", "publicVideoWatchWord", "getPublicVideoWatchWord", "readPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "watchWordCount", "", "getWatchWordCount", "()I", "watchWordObserver", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/RIJWatchWordShareManager$OnWatchWordCheck;", "Lkotlin/collections/ArrayList;", "addWatchWordObserver", "", "observer", "clearClipBoard", "getAppearCount", "pattern", "master", "getClipWording", "watchWord", "isOpen", "", "type", "title", "getJumpUrlFromWatchWord", "getTextFromClipBoard", "callback", "Lkotlin/Function1;", "getWatchWordFromText", "text", "isRIJShareWatchWord", "jumpAction", "jumpUrl", "jumpToTargetPage", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "onAppForeground", "removeWatchWordObjserver", "reportClick", "popupType", "rowkey", "columnId", "uin", "", "clickType", "reportExpose", "saveWatchWord2JumpUrl", "Companion", "OnWatchWordCheck", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rbw
  implements rcb
{
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJWatchWordShareManager.Companion.instance.2.INSTANCE);
  public static final rbx a;
  private final int jdField_a_of_type_Int = 50;
  private final ArrayList<rby> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedHashMap<String, String> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private final rch jdField_a_of_type_Rch = new rch((rca)new rcf());
  
  static
  {
    jdField_a_of_type_Rbx = new rbx(null);
  }
  
  public rbw()
  {
    this.jdField_a_of_type_Rch.a((rcb)this);
  }
  
  private final String a()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_topic_text", pha.g(2131717255));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_topic_text))");
    return str;
  }
  
  private final String b()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_topic_text", pha.g(2131717253));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_topic_text))");
    return str;
  }
  
  private final String c()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_video_text", pha.g(2131717256));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_video_text))");
    return str;
  }
  
  private final String d()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_video_text", pha.g(2131717254));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_video_text))");
    return str;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, boolean paramBoolean, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "title");
    paramString1 = new RIJWatchWordShareManager.getClipWording.1(paramString2, paramString1);
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return paramString1.invoke(c());
      }
      return paramString1.invoke(d());
    }
    if (paramBoolean) {
      return paramString1.invoke(a());
    }
    return paramString1.invoke(b());
  }
  
  public final void a()
  {
    ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, (CharSequence)""));
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 50) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(((Map.Entry)((Map)this.jdField_a_of_type_JavaUtilLinkedHashMap).entrySet().iterator().next()).getKey());
    }
    ((Map)this.jdField_a_of_type_JavaUtilLinkedHashMap).put(paramString1, paramString2);
  }
  
  public final void a(@NotNull rby paramrby)
  {
    Intrinsics.checkParameterIsNotNull(paramrby, "observer");
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramrby)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramrby);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbw
 * JD-Core Version:    0.7.0.1
 */