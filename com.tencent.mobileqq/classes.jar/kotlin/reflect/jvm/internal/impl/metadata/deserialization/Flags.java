package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import org.jetbrains.annotations.NotNull;

public class Flags
{
  public static final Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND;
  public static final Flags.BooleanFlagField DECLARES_DEFAULT_VALUE;
  public static final Flags.BooleanFlagField HAS_ANNOTATIONS;
  public static final Flags.BooleanFlagField HAS_CONSTANT;
  public static final Flags.BooleanFlagField HAS_GETTER;
  public static final Flags.BooleanFlagField HAS_SETTER;
  public static final Flags.BooleanFlagField IS_CONST;
  public static final Flags.BooleanFlagField IS_CROSSINLINE;
  public static final Flags.BooleanFlagField IS_DATA;
  public static final Flags.BooleanFlagField IS_DELEGATED;
  public static final Flags.BooleanFlagField IS_EXPECT_CLASS;
  public static final Flags.BooleanFlagField IS_EXPECT_FUNCTION;
  public static final Flags.BooleanFlagField IS_EXPECT_PROPERTY;
  public static final Flags.BooleanFlagField IS_EXTERNAL_ACCESSOR = Flags.FlagField.booleanAfter(IS_NOT_DEFAULT);
  public static final Flags.BooleanFlagField IS_EXTERNAL_CLASS;
  public static final Flags.BooleanFlagField IS_EXTERNAL_FUNCTION;
  public static final Flags.BooleanFlagField IS_EXTERNAL_PROPERTY;
  public static final Flags.BooleanFlagField IS_INFIX;
  public static final Flags.BooleanFlagField IS_INLINE;
  public static final Flags.BooleanFlagField IS_INLINE_ACCESSOR = Flags.FlagField.booleanAfter(IS_EXTERNAL_ACCESSOR);
  public static final Flags.BooleanFlagField IS_INLINE_CLASS;
  public static final Flags.BooleanFlagField IS_INNER;
  public static final Flags.BooleanFlagField IS_LATEINIT;
  public static final Flags.BooleanFlagField IS_NEGATED = Flags.FlagField.booleanFirst();
  public static final Flags.BooleanFlagField IS_NOINLINE;
  public static final Flags.BooleanFlagField IS_NOT_DEFAULT;
  public static final Flags.BooleanFlagField IS_NULL_CHECK_PREDICATE = Flags.FlagField.booleanAfter(IS_NEGATED);
  public static final Flags.BooleanFlagField IS_OPERATOR;
  public static final Flags.BooleanFlagField IS_SECONDARY;
  public static final Flags.BooleanFlagField IS_SUSPEND;
  public static final Flags.BooleanFlagField IS_TAILREC;
  public static final Flags.BooleanFlagField IS_UNSIGNED = Flags.FlagField.booleanFirst();
  public static final Flags.BooleanFlagField IS_VAR;
  public static final Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND;
  public static final Flags.FlagField<ProtoBuf.Modality> MODALITY;
  public static final Flags.BooleanFlagField SUSPEND_TYPE = ;
  public static final Flags.FlagField<ProtoBuf.Visibility> VISIBILITY;
  
  static
  {
    HAS_ANNOTATIONS = Flags.FlagField.booleanFirst();
    VISIBILITY = Flags.FlagField.after(HAS_ANNOTATIONS, ProtoBuf.Visibility.values());
    MODALITY = Flags.FlagField.after(VISIBILITY, ProtoBuf.Modality.values());
    CLASS_KIND = Flags.FlagField.after(MODALITY, ProtoBuf.Class.Kind.values());
    IS_INNER = Flags.FlagField.booleanAfter(CLASS_KIND);
    IS_DATA = Flags.FlagField.booleanAfter(IS_INNER);
    IS_EXTERNAL_CLASS = Flags.FlagField.booleanAfter(IS_DATA);
    IS_EXPECT_CLASS = Flags.FlagField.booleanAfter(IS_EXTERNAL_CLASS);
    IS_INLINE_CLASS = Flags.FlagField.booleanAfter(IS_EXPECT_CLASS);
    IS_SECONDARY = Flags.FlagField.booleanAfter(VISIBILITY);
    MEMBER_KIND = Flags.FlagField.after(MODALITY, ProtoBuf.MemberKind.values());
    IS_OPERATOR = Flags.FlagField.booleanAfter(MEMBER_KIND);
    IS_INFIX = Flags.FlagField.booleanAfter(IS_OPERATOR);
    IS_INLINE = Flags.FlagField.booleanAfter(IS_INFIX);
    IS_TAILREC = Flags.FlagField.booleanAfter(IS_INLINE);
    IS_EXTERNAL_FUNCTION = Flags.FlagField.booleanAfter(IS_TAILREC);
    IS_SUSPEND = Flags.FlagField.booleanAfter(IS_EXTERNAL_FUNCTION);
    IS_EXPECT_FUNCTION = Flags.FlagField.booleanAfter(IS_SUSPEND);
    IS_VAR = Flags.FlagField.booleanAfter(MEMBER_KIND);
    HAS_GETTER = Flags.FlagField.booleanAfter(IS_VAR);
    HAS_SETTER = Flags.FlagField.booleanAfter(HAS_GETTER);
    IS_CONST = Flags.FlagField.booleanAfter(HAS_SETTER);
    IS_LATEINIT = Flags.FlagField.booleanAfter(IS_CONST);
    HAS_CONSTANT = Flags.FlagField.booleanAfter(IS_LATEINIT);
    IS_EXTERNAL_PROPERTY = Flags.FlagField.booleanAfter(HAS_CONSTANT);
    IS_DELEGATED = Flags.FlagField.booleanAfter(IS_EXTERNAL_PROPERTY);
    IS_EXPECT_PROPERTY = Flags.FlagField.booleanAfter(IS_DELEGATED);
    DECLARES_DEFAULT_VALUE = Flags.FlagField.booleanAfter(HAS_ANNOTATIONS);
    IS_CROSSINLINE = Flags.FlagField.booleanAfter(DECLARES_DEFAULT_VALUE);
    IS_NOINLINE = Flags.FlagField.booleanAfter(IS_CROSSINLINE);
    IS_NOT_DEFAULT = Flags.FlagField.booleanAfter(MODALITY);
  }
  
  public static int getAccessorFlags(boolean paramBoolean1, @NotNull ProtoBuf.Visibility paramVisibility, @NotNull ProtoBuf.Modality paramModality, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(10);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(11);
    }
    return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(paramBoolean1)) | MODALITY.toFlags(paramModality) | VISIBILITY.toFlags(paramVisibility) | IS_NOT_DEFAULT.toFlags(Boolean.valueOf(paramBoolean2)) | IS_EXTERNAL_ACCESSOR.toFlags(Boolean.valueOf(paramBoolean3)) | IS_INLINE_ACCESSOR.toFlags(Boolean.valueOf(paramBoolean4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags
 * JD-Core Version:    0.7.0.1
 */