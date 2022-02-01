package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class OperatorNameConventions
{
  @JvmField
  @NotNull
  public static final Name AND;
  @JvmField
  @NotNull
  public static final Set<Name> ASSIGNMENT_OPERATIONS = SetsKt.setOf(new Name[] { TIMES_ASSIGN, DIV_ASSIGN, MOD_ASSIGN, REM_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN });
  @JvmField
  @NotNull
  public static final Set<Name> BINARY_OPERATION_NAMES;
  @JvmField
  @NotNull
  public static final Name COMPARE_TO;
  @JvmField
  @NotNull
  public static final Regex COMPONENT_REGEX;
  @JvmField
  @NotNull
  public static final Name CONTAINS;
  @JvmField
  @NotNull
  public static final Name DEC;
  @JvmField
  @NotNull
  public static final Set<Name> DELEGATED_PROPERTY_OPERATORS = SetsKt.setOf(new Name[] { GET_VALUE, SET_VALUE, PROVIDE_DELEGATE });
  @JvmField
  @NotNull
  public static final Name DIV;
  @JvmField
  @NotNull
  public static final Name DIV_ASSIGN;
  @JvmField
  @NotNull
  public static final Name EQUALS;
  @JvmField
  @NotNull
  public static final Name GET;
  @JvmField
  @NotNull
  public static final Name GET_VALUE;
  @JvmField
  @NotNull
  public static final Name HAS_NEXT;
  @JvmField
  @NotNull
  public static final Name INC;
  public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();
  @JvmField
  @NotNull
  public static final Name INVOKE;
  @JvmField
  @NotNull
  public static final Name ITERATOR;
  @JvmField
  @NotNull
  public static final Name MINUS;
  @JvmField
  @NotNull
  public static final Name MINUS_ASSIGN;
  @JvmField
  @NotNull
  public static final Name MOD;
  @JvmField
  @NotNull
  public static final Name MOD_ASSIGN;
  @JvmField
  @NotNull
  public static final Name NEXT;
  @JvmField
  @NotNull
  public static final Name NOT;
  @JvmField
  @NotNull
  public static final Name OR;
  @JvmField
  @NotNull
  public static final Name PLUS;
  @JvmField
  @NotNull
  public static final Name PLUS_ASSIGN;
  @JvmField
  @NotNull
  public static final Name PROVIDE_DELEGATE;
  @JvmField
  @NotNull
  public static final Name RANGE_TO;
  @JvmField
  @NotNull
  public static final Name REM;
  @JvmField
  @NotNull
  public static final Name REM_ASSIGN;
  @JvmField
  @NotNull
  public static final Name SET;
  @JvmField
  @NotNull
  public static final Name SET_VALUE;
  @JvmField
  @NotNull
  public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
  @JvmField
  @NotNull
  public static final Name TIMES;
  @JvmField
  @NotNull
  public static final Name TIMES_ASSIGN;
  @JvmField
  @NotNull
  public static final Name UNARY_MINUS;
  @JvmField
  @NotNull
  public static final Set<Name> UNARY_OPERATION_NAMES;
  @JvmField
  @NotNull
  public static final Name UNARY_PLUS;
  
  static
  {
    Name localName = Name.identifier("getValue");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"getValue\")");
    GET_VALUE = localName;
    localName = Name.identifier("setValue");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"setValue\")");
    SET_VALUE = localName;
    localName = Name.identifier("provideDelegate");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"provideDelegate\")");
    PROVIDE_DELEGATE = localName;
    localName = Name.identifier("equals");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"equals\")");
    EQUALS = localName;
    localName = Name.identifier("compareTo");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"compareTo\")");
    COMPARE_TO = localName;
    localName = Name.identifier("contains");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"contains\")");
    CONTAINS = localName;
    localName = Name.identifier("invoke");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"invoke\")");
    INVOKE = localName;
    localName = Name.identifier("iterator");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"iterator\")");
    ITERATOR = localName;
    localName = Name.identifier("get");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"get\")");
    GET = localName;
    localName = Name.identifier("set");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"set\")");
    SET = localName;
    localName = Name.identifier("next");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"next\")");
    NEXT = localName;
    localName = Name.identifier("hasNext");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"hasNext\")");
    HAS_NEXT = localName;
    COMPONENT_REGEX = new Regex("component\\d+");
    localName = Name.identifier("and");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"and\")");
    AND = localName;
    localName = Name.identifier("or");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"or\")");
    OR = localName;
    localName = Name.identifier("inc");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"inc\")");
    INC = localName;
    localName = Name.identifier("dec");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"dec\")");
    DEC = localName;
    localName = Name.identifier("plus");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"plus\")");
    PLUS = localName;
    localName = Name.identifier("minus");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"minus\")");
    MINUS = localName;
    localName = Name.identifier("not");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"not\")");
    NOT = localName;
    localName = Name.identifier("unaryMinus");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"unaryMinus\")");
    UNARY_MINUS = localName;
    localName = Name.identifier("unaryPlus");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"unaryPlus\")");
    UNARY_PLUS = localName;
    localName = Name.identifier("times");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"times\")");
    TIMES = localName;
    localName = Name.identifier("div");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"div\")");
    DIV = localName;
    localName = Name.identifier("mod");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"mod\")");
    MOD = localName;
    localName = Name.identifier("rem");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"rem\")");
    REM = localName;
    localName = Name.identifier("rangeTo");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"rangeTo\")");
    RANGE_TO = localName;
    localName = Name.identifier("timesAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"timesAssign\")");
    TIMES_ASSIGN = localName;
    localName = Name.identifier("divAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"divAssign\")");
    DIV_ASSIGN = localName;
    localName = Name.identifier("modAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"modAssign\")");
    MOD_ASSIGN = localName;
    localName = Name.identifier("remAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"remAssign\")");
    REM_ASSIGN = localName;
    localName = Name.identifier("plusAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"plusAssign\")");
    PLUS_ASSIGN = localName;
    localName = Name.identifier("minusAssign");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"minusAssign\")");
    MINUS_ASSIGN = localName;
    UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[] { INC, DEC, UNARY_PLUS, UNARY_MINUS, NOT });
    SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[] { UNARY_PLUS, UNARY_MINUS, NOT });
    BINARY_OPERATION_NAMES = SetsKt.setOf(new Name[] { TIMES, PLUS, MINUS, DIV, MOD, REM, RANGE_TO });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions
 * JD-Core Version:    0.7.0.1
 */