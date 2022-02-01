package com.tencent.mobileqq.vas.kingcard;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/kingcard/KingCardManagerImpl;", "Lcom/tencent/mobileqq/vas/kingcard/IKingCardManager;", "()V", "managerName", "", "getManagerName", "()Ljava/lang/String;", "addChangeListener", "", "block", "Lkotlin/Function1;", "", "isKingCard", "setKingCardState", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class KingCardManagerImpl
  implements IKingCardManager
{
  public static final KingCardManagerImpl.Companion a;
  @NotNull
  private final String a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasKingcardKingCardManagerImpl$Companion = new KingCardManagerImpl.Companion(null);
  }
  
  public KingCardManagerImpl()
  {
    this.jdField_a_of_type_JavaLangString = "KingCardManagerImpl";
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("KingCardManagerImpl", 2, "setKingCardState=" + paramBoolean);
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("qq_vas_kingcard", 0).edit();
    if (paramBoolean) {
      i = 1;
    }
    localEditor.putInt("kingCardSdk", i).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.kingcard.KingCardManagerImpl
 * JD-Core Version:    0.7.0.1
 */