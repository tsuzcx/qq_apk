import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "getOnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "cmdStrId", "", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initAdDownloadAreaClickListener", "initAdImageAreaClickListener", "initAdItemClickListener", "initAdNameClickListener", "initAdTagClickListener", "initAdTimeAreaClickListener", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "", "onClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ope
{
  private final opd a()
  {
    return (opd)new oqk();
  }
  
  private final opd a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (opd)new oqw();
  }
  
  private final void a(int paramInt, opd paramopd, SparseArray<opd> paramSparseArray)
  {
    if (paramopd != null) {
      paramSparseArray.put(paramInt, paramopd);
    }
  }
  
  private final opd b(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (opd)new oqv();
  }
  
  private final opd c(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (opd)new opt();
  }
  
  private final opd d(int paramInt)
  {
    if (paramInt != 1055) {
      return null;
    }
    return (opd)new oqi();
  }
  
  private final opd e(int paramInt)
  {
    if (paramInt != 1059) {
      return null;
    }
    return (opd)new oqm();
  }
  
  private final opd f(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (opd)new opz();
  }
  
  private final opd g(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (opd)new oqo();
  }
  
  private final opd h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (opd)new opx();
  }
  
  private final opd i(int paramInt)
  {
    if (paramInt != 1064) {
      return null;
    }
    return (opd)new oqt();
  }
  
  private final opd j(int paramInt)
  {
    if (paramInt != 1072) {
      return null;
    }
    return (opd)new opv();
  }
  
  private final opd k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (opd)new opr();
  }
  
  private final opd l(int paramInt)
  {
    if (paramInt != 1093) {
      return null;
    }
    return (opd)new oqc();
  }
  
  private final opd m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (opd)new oqg();
  }
  
  private final opd n(int paramInt)
  {
    if (paramInt != 1079) {
      return null;
    }
    return (opd)new oqp();
  }
  
  private final opd o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (opd)new oqr();
  }
  
  private final opd p(int paramInt)
  {
    if (paramInt != 1158) {
      return null;
    }
    return (opd)new oqe();
  }
  
  private final opd q(int paramInt)
  {
    if (paramInt != 1119) {
      return null;
    }
    return (opd)new oph();
  }
  
  private final opd r(int paramInt)
  {
    if (paramInt != 1177) {
      return null;
    }
    return (opd)new opn();
  }
  
  private final opd s(int paramInt)
  {
    if (paramInt != 1178) {
      return null;
    }
    return (opd)new opp();
  }
  
  private final opd t(int paramInt)
  {
    if (paramInt != 1179) {
      return null;
    }
    return (opd)new opl();
  }
  
  private final opd u(int paramInt)
  {
    if (paramInt != 1103) {
      return null;
    }
    return (opd)new opf();
  }
  
  private final opd v(int paramInt)
  {
    if (paramInt != 1180) {
      return null;
    }
    return (opd)new opj();
  }
  
  @NotNull
  public final opd a(int paramInt, @NotNull SparseArray<opd> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (opd)paramSparseArray.get(paramInt);
    if (paramSparseArray != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] succeed, cmdStrId = " + paramInt);
      }
      return paramSparseArray;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] use default clickListener, cmdStrId = " + paramInt);
    }
    return ((ope)this).a();
  }
  
  @NotNull
  public final ope a(int paramInt, @NotNull SparseArray<opd> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    ((ope)this).a(paramInt, ((ope)this).a(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).b(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).c(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).d(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).e(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).f(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).g(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).h(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).i(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).j(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).k(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).l(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).m(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).n(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).o(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).p(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).q(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).r(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).s(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).t(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).u(paramInt), paramSparseArray);
    ((ope)this).a(paramInt, ((ope)this).v(paramInt), paramSparseArray);
    return (ope)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */