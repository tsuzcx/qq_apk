package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalContracts
@ContractsDsl
public abstract interface ContractBuilder
{
  @ContractsDsl
  @NotNull
  public abstract <R> CallsInPlace callsInPlace(@NotNull Function<? extends R> paramFunction, @NotNull InvocationKind paramInvocationKind);
  
  @ContractsDsl
  @NotNull
  public abstract Returns returns();
  
  @ContractsDsl
  @NotNull
  public abstract Returns returns(@Nullable Object paramObject);
  
  @ContractsDsl
  @NotNull
  public abstract ReturnsNotNull returnsNotNull();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.contracts.ContractBuilder
 * JD-Core Version:    0.7.0.1
 */