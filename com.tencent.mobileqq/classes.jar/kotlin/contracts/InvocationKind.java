package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/contracts/InvocationKind;", "", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalContracts
@ContractsDsl
public enum InvocationKind
{
  static
  {
    InvocationKind localInvocationKind1 = new InvocationKind("AT_MOST_ONCE", 0);
    AT_MOST_ONCE = localInvocationKind1;
    InvocationKind localInvocationKind2 = new InvocationKind("AT_LEAST_ONCE", 1);
    AT_LEAST_ONCE = localInvocationKind2;
    InvocationKind localInvocationKind3 = new InvocationKind("EXACTLY_ONCE", 2);
    EXACTLY_ONCE = localInvocationKind3;
    InvocationKind localInvocationKind4 = new InvocationKind("UNKNOWN", 3);
    UNKNOWN = localInvocationKind4;
    $VALUES = new InvocationKind[] { localInvocationKind1, localInvocationKind2, localInvocationKind3, localInvocationKind4 };
  }
  
  private InvocationKind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.contracts.InvocationKind
 * JD-Core Version:    0.7.0.1
 */