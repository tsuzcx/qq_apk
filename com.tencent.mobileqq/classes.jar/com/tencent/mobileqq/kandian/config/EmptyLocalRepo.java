package com.tencent.mobileqq.kandian.config;

import com.tencent.mobileqq.kandian.config.interface.IConfigLocalRepo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/config/EmptyLocalRepo;", "Lcom/tencent/mobileqq/kandian/config/interface/IConfigLocalRepo;", "()V", "illegalStateException", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "readBoolean", "", "key", "", "defaultValue", "readFloat", "", "readInt", "", "readLong", "", "readString", "writeBoolean", "", "value", "writeFloat", "writeInt", "writeLong", "writeString", "kandian-config"}, k=1, mv={1, 1, 16})
public final class EmptyLocalRepo
  implements IConfigLocalRepo
{
  public static final EmptyLocalRepo a;
  private static final IllegalStateException a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianConfigEmptyLocalRepo = new EmptyLocalRepo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("You should implement your own ");
    localStringBuilder.append(IConfigLocalRepo.class.getSimpleName());
    localStringBuilder.append(" and bind with ");
    localStringBuilder.append(RemoteConfig.class);
    jdField_a_of_type_JavaLangIllegalStateException = new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.config.EmptyLocalRepo
 * JD-Core Version:    0.7.0.1
 */